package net.craftlin.bukkit.impl.inventory

import net.craftlin.api.inventory.Item
import net.craftlin.bukkit.impl.value.BukkitItemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BukkitItem(private val origin: ItemStack): Item {
    private var originType: Material
        get() = origin.type
        set(value) { origin.type = value }

    override var type by BukkitItemType.Delegate(::originType)
    override var amount: Long
        get() = origin.amount.toLong()
        set(value) { origin.amount = value.toInt() }
}