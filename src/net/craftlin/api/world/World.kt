package net.craftlin.api.world

import net.craftlin.api.entity.Player
import net.craftlin.api.world.block.Block
import net.craftlin.api.value.WorldType

/**
 * Represents a Minecraft world
 */
interface World {
    /** The world's name */
    val name: String
    /**
     * The world's type
     * @see WorldType
     */
    val type: String
    /** Players that are staying in the world */
    val players: List<Player>

    /** @return [Block] at specified position */
    fun blockAt(x: Int, y: Int, z: Int): Block
    /** @return [Block] at specified position */
    fun blockAt(location: Location) = blockAt(location.blockX, location.blockY, location.blockZ)
    /** @return [Block] at specified position */
    fun spawnMob(type: String, location: Location)
}