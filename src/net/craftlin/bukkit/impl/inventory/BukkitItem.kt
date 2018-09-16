package net.craftlin.bukkit.impl.inventory

import net.craftlin.api.inventory.Item
import net.craftlin.api.util.value.Converter
import net.craftlin.bukkit.impl.value.BukkitItemType
import org.bukkit.inventory.ItemStack

object BukkitItem: Converter<Item, ItemStack>() {

    override fun toImpl(value: Item) = ItemStack(
        BukkitItemType.Converter(value.type),
        value.amount.toInt()
    )

    override fun toApi(origin: ItemStack) = Item(
        BukkitItemType.Converter(origin.type),
        origin.amount.toLong()
    )
}