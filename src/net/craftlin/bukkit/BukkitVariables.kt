package net.craftlin.bukkit

import net.craftlin.api.Variables
import net.craftlin.api.misc.Timer
import net.craftlin.api.misc.itF
import net.craftlin.api.misc.thisF
import net.craftlin.api.util.Listener
import net.craftlin.bukkit.impl.BukkitServer
import net.craftlin.bukkit.impl.misc.BukkitTask
import net.craftlin.bukkit.impl.misc.BukkitTimer
import org.bukkit.plugin.java.JavaPlugin

class BukkitVariables(private val plugin: JavaPlugin, listener: Listener): Variables(listener) {

    override val server = BukkitServer
    override val sync = fun(callback: itF) { BukkitTask(callback).runTask(plugin) }
    override val async = fun(callback: itF) { BukkitTask(callback).runTaskAsynchronously(plugin) }
    override val delay = fun(time: Long, callback: itF) { BukkitTask(callback).runTaskLater(plugin, time) }
    override val delayAsync = fun(time: Long, callback: itF) { BukkitTask(callback).runTaskLaterAsynchronously(plugin, time) }
    override val timer = fun(time: Long, callback: thisF<Timer>) { BukkitTimer(callback).runTaskTimer(plugin, 0, time) }
    override val timerAsync = fun(time: Long, callback: thisF<Timer>) { BukkitTimer(callback).runTaskTimerAsynchronously(plugin, 0, time) }

}