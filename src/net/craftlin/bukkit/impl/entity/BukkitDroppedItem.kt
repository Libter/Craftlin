package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.DroppedItem
import net.craftlin.bukkit.impl.entity.base.BukkitEntity
import net.craftlin.bukkit.impl.inventory.BukkitItem

class BukkitDroppedItem(private val origin: org.bukkit.entity.Item): BukkitEntity(origin), DroppedItem {
    override val item get() = BukkitItem.toApi(origin.itemStack)
}