package net.craftlin.plugin.bukkit.impl.world

import net.craftlin.plugin.api.world.Block
import net.craftlin.plugin.bukkit.impl.value.BukkitBlockType

class BukkitBlock(origin: org.bukkit.block.Block): Block() {
    override var type by BukkitBlockType.Delegate(origin.type)
    override val location = BukkitLocation(origin.location)
}