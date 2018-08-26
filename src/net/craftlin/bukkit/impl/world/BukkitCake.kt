package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.block.Cake
import org.bukkit.block.Block

class BukkitCake(private val origin: org.bukkit.block.data.type.Cake): BukkitBlock(origin as Block), Cake {
    override var bites: Long
        get() = origin.bites.toLong()
        set(value) { origin.bites = value.toInt() }
    override val maxBites: Long
        get() = origin.maximumBites.toLong()
}