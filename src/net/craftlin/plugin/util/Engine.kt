package net.craftlin.plugin.util

import java.io.File
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.WildcardType
import java.nio.charset.Charset
import javax.script.ScriptEngine

private typealias EngineFactory = org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory

object Engine {

    private val charset = Charset.forName("UTF-8") ?: throw RuntimeException("Can't find UTF-8 charset!")
    private val variables = HashMap<String,Any>()
    private lateinit var factory: EngineFactory

    fun load() {
        //TODO: download and load org.jetbrains.kotlin:kotlin-compiler-embeddable dynamically... it makes our fat jar too much fat
        Logger.log("Loading Kotlin scripting engine...")
        //We need to setup an environment before executing scripts
        org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback()
        //Then we are creating a factory
        factory = EngineFactory()
        //And all should be fine now... but wait
        //The engine uses a different ClassLoader which makes casting in setup() impossible
        //So we have to set custom ClassLoader which will be visible for future scripts
        val engine = setup()
        engine.put("loader", this::class.java.classLoader)
        engine.eval("""Thread.currentThread().contextClassLoader = (bindings["loader"] as java.lang.ClassLoader)""")
    }

    fun variables(map: Map<String,Any>) = variables.putAll(map)

    private fun setup(): ScriptEngine {
        val engine = factory.scriptEngine
        if (!variables.isEmpty()) {
            //Values passed to script are stored in bindings: Map<String,Any?>
            //So we have to create declarations with explicit types
            val script = variables.map {
                engine.put(it.key, it.value)
                val type = parseType(it.value::class.java)
                """val ${it.key} = bindings["${it.key}"] as $type"""
            }.joinToString("\n")
            engine.eval(script)
        }
        return engine
    }

    fun run(script: String) = setup().eval(script)
    fun run(file: File)= run(file.readText(charset))

    private fun parseType(type: Type): String {
        //Creating a string representation of variable's type isn't an easy thing...
        when (type) {
            //Just simple type of class
            is Class<*> -> {
                //If it's KFunction
                if (isType(type, "kotlin.jvm.internal.Function") || isType(type, "kotlin.jvm.function")) {
                    type.methods.filter { it.name == "invoke" }.forEach { method ->
                        val generics = method.genericParameterTypes
                        //We are looking only for concrete types
                        if (generics.isEmpty() || generics[0].typeName == "java.lang.Object") return@forEach
                        return parseFunction(method.genericParameterTypes.toList(), method.returnType)
                    }
                }
                //Else it's a simple class
                return simpleParseType(type.canonicalName ?: type.typeName)
            }
            //Wildcard types are like <T: BasicType>
            is WildcardType -> {
                return parseType(type.lowerBounds[0])
            }
            //Parameterized type are like Map<T1,T2>, we assume that they appears only in KFunctions
            is ParameterizedType -> {
                val types = type.actualTypeArguments
                //The last type is a function output, the rest are an input
                return parseFunction(types.slice(0..types.size - 2), types[1])
            }
            else -> return simpleParseType(type.typeName)
        }
    }

    private fun simpleParseType(type: String): String {
        //We are operating on Java types which should be translated to Kotlin
        return when(type) {
            "void" -> "kotlin.Unit"
            "boolean" -> "kotlin.Boolean"
            "byte" -> "kotlin.Byte"
            "char" -> "kotlin.Char"
            "int" -> "kotlin.Int"
            "long" -> "kotlin.Long"
            "float" -> "kotlin.Float"
            "double" -> "kotlin.Double"
            "java.lang.String" -> "kotlin.String"
            else -> type
        }
    }

    private fun parseFunction(params: List<Type>, _return: Type): String {
        val parsedParams = params.joinToString(", ", transform = ::parseType)
        val parsedReturn = parseType(_return)
        if (params.size == 1 && isType(params[0], "net.craftlin.plugin.api.event")) {
            return "$parsedParams.() -> $parsedReturn"
        }
        return "($parsedParams) -> $parsedReturn"
    }

    private fun isType(type: Type?, start: String): Boolean {
        if (type is ParameterizedType) return isType(type.rawType, start)
        if (type is WildcardType) return isType(type.lowerBounds[0], start)
        if (type is Class<*>) return type.name.startsWith(start) || isType(type.superclass, start)
        return false
    }

}