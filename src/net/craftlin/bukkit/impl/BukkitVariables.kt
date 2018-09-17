package net.craftlin.bukkit.impl

import net.craftlin.api.Variables
import net.craftlin.api.misc.Block
import net.craftlin.api.misc.ThisBlock
import net.craftlin.api.misc.Timer
import net.craftlin.api.util.Commands
import net.craftlin.api.util.Listener
import net.craftlin.bukkit.impl.misc.BukkitTask
import net.craftlin.bukkit.impl.misc.BukkitTimer
import org.bukkit.plugin.java.JavaPlugin

class BukkitVariables(private val plugin: JavaPlugin, listener: Listener, commands: Commands):
    Variables(listener, commands) {

    override val server = BukkitServer
    override val sync = fun(callback: Block) { BukkitTask(callback).runTask(plugin) }
    override val async = fun(callback: Block) { BukkitTask(callback).runTaskAsynchronously(plugin) }
    override val delay = fun(time: Long, callback: Block) { BukkitTask(callback).runTaskLater(plugin, time) }
    override val delayAsync = fun(time: Long, callback: Block) { BukkitTask(callback).runTaskLaterAsynchronously(plugin, time) }
    override val timer = fun(time: Long, callback: ThisBlock<Timer>) { BukkitTimer(callback).runTaskTimer(plugin, 0, time) }
    override val timerAsync = fun(time: Long, callback: ThisBlock<Timer>) { BukkitTimer(callback).runTaskTimerAsynchronously(plugin, 0, time) }

}