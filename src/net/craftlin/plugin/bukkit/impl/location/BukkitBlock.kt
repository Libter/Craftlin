package net.craftlin.plugin.bukkit.impl.location

import net.craftlin.plugin.api.location.Block
import net.craftlin.plugin.api.value.EnumDelegate
import net.craftlin.plugin.bukkit.impl.value.BukkitMaterial

class BukkitBlock(private val origin: org.bukkit.block.Block): Block() {
    override var type by EnumDelegate(BukkitMaterial, origin.type)
    override val location = BukkitLocation(origin.location)
}