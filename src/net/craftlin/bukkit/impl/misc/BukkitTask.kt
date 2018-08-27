package net.craftlin.bukkit.impl.misc

import net.craftlin.api.misc.Stoppable
import net.craftlin.api.misc.emptyF
import org.bukkit.scheduler.BukkitRunnable

class BukkitTask(private val callback: emptyF): BukkitRunnable() {

    private val stoppable = object: Stoppable() {
        override fun stop() = cancel()
    }

    override fun run() {
        callback()
    }

}