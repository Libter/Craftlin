package net.craftlin.plugin.bukkit

import net.craftlin.plugin.api.util.Engine
import net.craftlin.plugin.api.util.Logger
import net.craftlin.plugin.bukkit.impl.BukkitListener
import org.bukkit.Bukkit
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class BukkitCraftlin: JavaPlugin() {

    companion object {
        lateinit var instance: BukkitCraftlin
            private set
        lateinit var listener: BukkitListener
            private set

        fun loadScripts() {
            Engine.put(BukkitVariables(instance, listener))

            val directory = File(Bukkit.getServer().worldContainer, "scripts")
            Logger.log("Loading scripts in ${directory.absolutePath}...")
            if (!directory.exists()) directory.mkdir()
            directory.listFiles { _, name -> name.endsWith(".cl") }.forEach {
                Logger.log("Loading ${it.name}")
                Engine.run(it)
            }
            Logger.log("Executing join events for players...")
            Bukkit.getOnlinePlayers().forEach {
                listener.triggerJoin(PlayerJoinEvent(it, ""))
            }
            Logger.log("Scripts loaded!")
        }
    }

    override fun onEnable() {
        instance = this
        Logger.reset()
        Engine.load()

        Logger.log("Loading listeners...")
        listener = BukkitListener()
        server.pluginManager.registerEvents(listener, this)

        Logger.log("Loading commands...")
        getCommand("craftlin").executor = CraftlinCommand()

        loadScripts()
    }

}