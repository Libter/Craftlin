package net.craftlin.api.inventory

import net.craftlin.api.value.world.ItemType

/**
 * Represents an item stack
 */
interface Item {
    /** @see ItemType */
    var type: String
    /** DroppedItem amount (from 0 to 64) */
    var amount: Long
}