package net.craftlin.plugin.bukkit

import net.craftlin.plugin.api.Variables
import net.craftlin.plugin.bukkit.impl.BukkitListener
import net.craftlin.plugin.util.Engine
import net.craftlin.plugin.util.Logger
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class BukkitCraftlin: JavaPlugin() {

    override fun onEnable() {
        Logger.reset()

        Engine.load()

        Logger.log("Loading listeners...")
        val listener = BukkitListener()
        server.pluginManager.registerEvents(listener, this)

        Engine.put(object: Variables(listener) { })

        val directory = File(server.worldContainer, "scripts")
        Logger.log("Loading scripts in ${directory.absolutePath}...")
        if (!directory.exists()) directory.mkdir()
        directory.listFiles { _, name -> name.endsWith(".cl") }.forEach {
            Logger.log("Running ${it.name}")
            Engine.run(it)
        }
    }

}