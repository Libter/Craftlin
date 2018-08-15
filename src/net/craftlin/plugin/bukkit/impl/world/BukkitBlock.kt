package net.craftlin.plugin.bukkit.impl.world

import net.craftlin.plugin.api.world.Block
import net.craftlin.plugin.bukkit.impl.value.BukkitBlockType
import org.bukkit.Material

class BukkitBlock(private val origin: org.bukkit.block.Block): Block {
    private var originType: Material
        get() = origin.type
        set(value) { origin.type = value }

    override var type by BukkitBlockType.Delegate(::originType)
    override val location = BukkitLocation(origin.location)
}