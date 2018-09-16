package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.block.Block
import net.craftlin.bukkit.impl.value.BukkitBlockType
import org.bukkit.Material

open class BukkitBlock(private val origin: org.bukkit.block.Block): Block {
    private var originType: Material
        get() = origin.type
        set(value) { origin.type = value }

    override var type by BukkitBlockType.Delegate(::originType)
    override val location = BukkitLocation.toApi(origin.location)
}