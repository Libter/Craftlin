package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.ItemType
import net.craftlin.plugin.api.value.base.EnumValue
import org.bukkit.Material

object BukkitItemType: EnumValue<ItemType, Material>(ItemType::class) {
    override fun convert(api: ItemType): Material {
        return when(api) {
            ItemType.DIAMOND_HOE -> Material.DIAMOND_HOE
        }
    }
}