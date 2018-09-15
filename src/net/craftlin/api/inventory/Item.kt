package net.craftlin.api.inventory

import net.craftlin.api.entity.DroppedItem
import net.craftlin.api.value.world.ItemType
import net.craftlin.api.world.Location

/**
 * Represents an item stack
 */
open class Item(
    /** @see ItemType */
    open var type: String,
    /** DroppedItem amount (from 0 to 64) */
    open var amount: Long
) {

    fun drop(location: Location): DroppedItem {
        return location.world.drop(this, location)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Item) return super.equals(other)
        return type == other.type && amount == other.amount
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + amount.hashCode()
        return result
    }
}