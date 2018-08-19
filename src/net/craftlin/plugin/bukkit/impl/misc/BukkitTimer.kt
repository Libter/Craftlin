package net.craftlin.plugin.bukkit.impl.misc

import net.craftlin.plugin.api.misc.Timer
import net.craftlin.plugin.api.misc.thisF
import org.bukkit.scheduler.BukkitRunnable

class BukkitTimer(private val callback: thisF<Timer>): BukkitRunnable() {

    private val timer = object: Timer() {
        override fun stop() = cancel()
    }

    override fun run() {
        callback(timer)
    }

}