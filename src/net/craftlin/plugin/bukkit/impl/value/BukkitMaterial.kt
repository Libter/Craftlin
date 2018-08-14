package net.craftlin.plugin.bukkit.impl.value

import org.bukkit.Material
import net.craftlin.plugin.api.value.EnumValue

object BukkitMaterial: EnumValue<Material>() {

    override val values = mapOf(
        "air" to Material.AIR,
        "stone" to Material.STONE,
        "dirt" to Material.DIRT,
        "diamond" to Material.DIAMOND
    )
}