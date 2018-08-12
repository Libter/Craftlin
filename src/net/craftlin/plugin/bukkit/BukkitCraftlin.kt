package net.craftlin.plugin.bukkit

import net.craftlin.plugin.util.Logger
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.nio.charset.Charset

class BukkitCraftlin: JavaPlugin() {

    override fun onEnable() {
        Logger.reset()

        //TODO: download and load org.jetbrains.kotlin:kotlin-compiler-embeddable dynamically... it makes our fat jar too much fat
        Logger.log("Loading Kotlin scripting engine...")
        org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback()
        val engine = org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory().scriptEngine
        val charset = Charset.forName("UTF-8") ?: throw RuntimeException("Can't find UTF-8 charset!")

        Logger.log("Enabling Kotlin scripting engine...")
        engine.eval("")

        val directory = File(server.worldContainer, "scripts")
        Logger.log("Loading scripts in ${directory.absolutePath}...")
        if (!directory.exists()) directory.mkdir()
        directory.listFiles { _, name -> name.endsWith(".cl") }.forEach {
            Logger.log("Running ${it.name}")
            engine.eval(it.reader(charset))
        }
    }

}