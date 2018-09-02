package net.craftlin.api.value.entity.modifier

/**
 * Represents an entity ignition.
 */
data class Ignition(var time: Long) {
    /**
     * Whether the ignition exists
     */
    val exists get() = time > 0

    /**
     * Removes the ignition
     */
    fun remove() { time = 0 }
}