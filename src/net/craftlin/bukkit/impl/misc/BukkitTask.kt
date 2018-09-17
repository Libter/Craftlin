package net.craftlin.bukkit.impl.misc

import net.craftlin.api.misc.Block
import net.craftlin.api.misc.Stoppable
import org.bukkit.scheduler.BukkitRunnable

class BukkitTask(private val callback: Block): BukkitRunnable() {

    private val stoppable = object: Stoppable() {
        override fun stop() = cancel()
    }

    override fun run() {
        callback()
    }

}