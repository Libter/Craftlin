package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.DroppedItem
import net.craftlin.bukkit.impl.entity.base.BukkitEntity
import net.craftlin.bukkit.impl.inventory.BukkitItem

class BukkitDroppedItem(origin: org.bukkit.entity.Item): BukkitEntity(origin), DroppedItem {
    override val item = BukkitItem(origin.itemStack)
}