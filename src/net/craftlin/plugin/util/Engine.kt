package net.craftlin.plugin.util

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import java.io.File
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.WildcardType
import java.nio.charset.Charset

object Engine {

    private val charset = Charset.forName("UTF-8") ?: throw RuntimeException("Can't find UTF-8 charset!")
    private val variables = HashMap<String,Any>()
    private lateinit var engine: KotlinJsr223JvmLocalScriptEngine

    fun load() {
        //TODO: download and load org.jetbrains.kotlin:kotlin-compiler-embeddable dynamically... it makes our fat jar too much fat
        Logger.log("Loading Kotlin scripting engine...")
        org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback()
        engine = KotlinJsr223JvmLocalScriptEngineFactory().scriptEngine as KotlinJsr223JvmLocalScriptEngine
        engine.eval("")
    }

    fun variables(map: Map<String,Any>) = variables.putAll(map)

    fun setup() {
        engine.state.history.reset()
        variables.forEach {
            val (key, value) = it
            val type = parseType(value::class.java)
            engine.put(key, value)
            engine.eval("""
                val $key = bindings["$key"] as $type
            """)
        }
    }

    fun run(script: String): Any? {
        setup()
        return engine.eval(script)
    }

    fun run(file: File): Any? {
        setup()
        var ret: Any? = null
        file.reader(charset).use {
            ret = engine.eval(it)
        }
        return ret
    }

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