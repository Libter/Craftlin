package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.ItemType
import org.bukkit.Material

object BukkitItemType: EnumValue<ItemType, Material>(ItemType::class) {
    override fun convert(api: ItemType) = when(api) {
        ItemType.DIAMOND_HOE -> Material.DIAMOND_HOE
    }
}