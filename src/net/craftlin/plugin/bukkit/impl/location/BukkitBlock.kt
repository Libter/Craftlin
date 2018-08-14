package net.craftlin.plugin.bukkit.impl.location

import net.craftlin.plugin.api.location.Block
import net.craftlin.plugin.bukkit.impl.value.BukkitMaterial

class BukkitBlock(private val origin: org.bukkit.block.Block): Block() {
    override var type: String
        get() = BukkitMaterial.toString(origin.type)
        set(value) { origin.type = BukkitMaterial.fromString(value) }
    override val location = BukkitLocation(origin.location)
}