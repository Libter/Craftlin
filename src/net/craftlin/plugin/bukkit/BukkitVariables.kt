package net.craftlin.plugin.bukkit

import net.craftlin.plugin.api.Variables
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.bukkit.impl.BukkitServer
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BukkitVariables(private val plugin: JavaPlugin, listener: Listener): Variables(listener) {

    private val S get() = Bukkit.getScheduler()
    override val server = BukkitServer
    override val sync = fun(callback: () -> Unit) { S.runTask(plugin, callback) }
    override val async = fun(callback: () -> Unit) { S.runTaskAsynchronously(plugin, callback) }
    override val delay = fun(time: Long, callback: () -> Unit) { S.runTaskLater(plugin, callback, time) }
    override val delayAsync = fun(time: Long, callback: () -> Unit) { S.runTaskLaterAsynchronously(plugin, callback, time) }
    override val timer = fun(time: Long, callback: () -> Unit) { S.runTaskTimer(plugin, callback, 0, time) }
    override val timerAsync = fun(time: Long, callback: () -> Unit) { S.runTaskTimerAsynchronously(plugin, callback, 0, time) }

}