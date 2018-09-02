package net.craftlin.api.world.block

import net.craftlin.api.value.world.BlockType
import net.craftlin.api.world.Location

/**
 * Represents a Minecraft block.
 */
interface Block {
    /** @see BlockType */
    var type: String
    val location: Location
}