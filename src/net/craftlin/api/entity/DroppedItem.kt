package net.craftlin.api.entity

import net.craftlin.api.entity.base.Entity
import net.craftlin.api.inventory.Item

interface DroppedItem: Entity {
    val item: Item
}