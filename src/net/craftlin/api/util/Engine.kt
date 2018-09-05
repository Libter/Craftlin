package net.craftlin.api.util

import net.craftlin.api.Variables
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream
import java.nio.charset.Charset
import java.util.Date
import javax.script.ScriptEngine
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties

private typealias EngineFactory = org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory

object Engine {

    private val charset = Charset.forName("UTF-8") ?: throw RuntimeException("Can't find UTF-8 charset!")
    private lateinit var variables: Variables
    private lateinit var factory: EngineFactory
    private val imports = listOf(
        "net.craftlin.api.Server",
        "net.craftlin.api.entity.*",
        "net.craftlin.api.event.*",
        "net.craftlin.api.inventory.*",
        "net.craftlin.api.world.*"
    )

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

    fun put(variables: Variables) {
        this.variables = variables
    }

    private fun setup(): ScriptEngine {
        val engine = factory.scriptEngine
        engine.eval(imports.joinToString("\n") { "import $it" })
        if (::variables.isInitialized) {
            //Values passed to script are stored in bindings: Map<String,Any?>
            //So we have to create declarations with explicit types
            val script = variables::class.memberProperties.filter { it.visibility == KVisibility.PUBLIC }.map {
                val name= it.name; val type = it.returnType.toString()
                engine.put(name, it.getter.call(variables))
                """val $name = bindings["$name"] as $type"""
            }.joinToString("\n")
            engine.eval(script)
        }
        return engine
    }

    fun run(script: String) = setup().eval(script)
    fun run(file: File) {
        try {
            run(file.readText(charset))
        } catch (t: Throwable) {
            val logDir = File(file.parentFile, "errors"); logDir.mkdirs()
            val log = File(logDir, file.nameWithoutExtension + ".txt")

            val error = ByteArrayOutputStream()
            val newLine = System.lineSeparator()
            PrintStream(error).use {
                it.append(newLine).append(Date().toString()).append(newLine)
                t.printStackTrace(it)
                it.append(newLine)
                Unit
            }

            val errorBytes = error.toByteArray()
            Logger.log("An error occurred while executing ${file.name} has been saved to ${log.canonicalPath}:")
            Logger.log(String(errorBytes, charset))

            FileOutputStream(log, true).use {
                it.write(errorBytes)
            }
        }
    }

}