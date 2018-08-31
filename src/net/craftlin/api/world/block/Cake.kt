package net.craftlin.api.world.block

/**
 * Represents a Minecraft cake.
 */
interface Cake: Block {

    var bites: Long
    val maxBites: Long

}