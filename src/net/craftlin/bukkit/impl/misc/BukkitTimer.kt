package net.craftlin.bukkit.impl.misc

import net.craftlin.api.misc.ThisBlock
import net.craftlin.api.misc.Timer
import org.bukkit.scheduler.BukkitRunnable

class BukkitTimer(private val callback: ThisBlock<Timer>): BukkitRunnable() {

    private val timer = object: Timer() {
        override fun stop() = cancel()
    }

    override fun run() {
        callback(timer)
    }

}