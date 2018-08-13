package net.craftlin.plugin.util

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import java.io.File
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.WildcardType
import java.nio.charset.Charset
import javax.script.ScriptEngine

object Engine {

    private val charset = Charset.forName("UTF-8") ?: throw RuntimeException("Can't find UTF-8 charset!")
    private val variables = HashMap<String,Any>()
    private lateinit var factory: KotlinJsr223JvmLocalScriptEngineFactory

    fun load() {
        //TODO: download and load org.jetbrains.kotlin:kotlin-compiler-embeddable dynamically... it makes our fat jar too much fat
        Logger.log("Loading Kotlin scripting engine...")
        org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback()
        factory = KotlinJsr223JvmLocalScriptEngineFactory()
        val engine = setup()
        engine.put("loader", this::class.java.classLoader)
        engine.eval("""Thread.currentThread().contextClassLoader = (bindings["loader"] as java.lang.ClassLoader)""")
    }

    fun variables(map: Map<String,Any>) = variables.putAll(map)

    private fun setup(): ScriptEngine {
        val engine = factory.scriptEngine
        if (!variables.isEmpty()) {
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
        if (type is Class<*>) {
            type.methods.filter { it.name == "invoke" }.forEach { method ->
                val types = method.genericParameterTypes
                val params = if (!types.isEmpty()) {
                    if (types[0].typeName == "java.lang.Object") return@forEach
                    method.genericParameterTypes.joinToString(", ", transform = ::parseType)
                } else {
                    method.parameterTypes.joinToString(", ", transform = ::parseType)
                }
                val ret = parseType(method.returnType)
                return "($params) -> $ret"
            }
            return simpleParseType(type.canonicalName ?: type.typeName)
        } else if (type is WildcardType) {
            return parseType(type.lowerBounds[0])
        } else if (type is ParameterizedType) {
            val types = type.actualTypeArguments
            val params = types.slice(0..types.size - 2).joinToString(", ", transform = ::parseType)
            val ret = parseType(types[1])
            return "($params) -> $ret"
        }
        return simpleParseType(type.typeName)
    }

    private fun simpleParseType(type: String): String {
        return when(type) {
            //TODO: more primitives
            "java.lang.String" -> "kotlin.String"
            "boolean" -> "Boolean"
            else -> type
        }
    }

}