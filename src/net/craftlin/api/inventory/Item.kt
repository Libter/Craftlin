package net.craftlin.api.inventory

import net.craftlin.api.value.ItemType

/**
 * Represents an item stack
 */
interface Item {
    /** @see ItemType */
    var type: String
    /** Item amount (from 0 to 64) */
    var amount: Long
}