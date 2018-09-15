package net.craftlin.bukkit.impl.inventory

import net.craftlin.api.inventory.Item
import net.craftlin.api.util.value.Converter
import net.craftlin.bukkit.impl.value.BukkitItemType
import org.bukkit.inventory.ItemStack

object BukkitItem: Converter<Item, ItemStack>() {

    override fun to(value: Item) = ItemStack(
        BukkitItemType.Converter(value.type),
        value.amount.toInt()
    )

    override fun from(origin: ItemStack) = Item(
        BukkitItemType.Converter(origin.type),
        origin.amount.toLong()
    )
}