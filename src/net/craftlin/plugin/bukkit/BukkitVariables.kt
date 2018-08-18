package net.craftlin.plugin.bukkit

import net.craftlin.plugin.api.Variables
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.api.itF
import net.craftlin.plugin.bukkit.impl.BukkitServer
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BukkitVariables(private val plugin: JavaPlugin, listener: Listener): Variables(listener) {

    private val S get() = Bukkit.getScheduler()
    override val server = BukkitServer
    override val sync = fun(callback: itF) { S.runTask(plugin, callback) }
    override val async = fun(callback: itF) { S.runTaskAsynchronously(plugin, callback) }
    override val delay = fun(time: Long, callback: itF) { S.runTaskLater(plugin, callback, time) }
    override val delayAsync = fun(time: Long, callback: itF) { S.runTaskLaterAsynchronously(plugin, callback, time) }
    override val timer = fun(time: Long, callback: itF) { S.runTaskTimer(plugin, callback, 0, time) }
    override val timerAsync = fun(time: Long, callback: itF) { S.runTaskTimerAsynchronously(plugin, callback, 0, time) }

}