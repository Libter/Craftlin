package net.craftlin.api.world.block

import net.craftlin.api.world.Location
import net.craftlin.api.value.BlockType

/**
 * Represents a Minecraft block.
 */
interface Block {
    /** @see BlockType */
    var type: String
    val location: Location
}