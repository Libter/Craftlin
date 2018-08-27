package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.block.Cake

class BukkitCake(origin: org.bukkit.block.Block): BukkitBlock(origin), Cake {
    private val cake = origin.blockData as org.bukkit.block.data.type.Cake
    override var bites: Long
        get() = cake.bites.toLong()
        set(value) { cake.bites = value.toInt() }
    override val maxBites: Long
        get() = cake.maximumBites.toLong()
}