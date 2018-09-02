package net.craftlin.api.world

import net.craftlin.api.entity.Player
import net.craftlin.api.value.WorldType
import net.craftlin.api.world.block.Block

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
    fun blockAt(x: Long, y: Long, z: Long): Block
    /** @return [Block] at specified position */
    fun blockAt(location: Location) = blockAt(location.blockX, location.blockY, location.blockZ)
    /**
     * Spawns mob of [type] at specified [location]
     * @see (todo: missing EntityType or something other like this)
     */
    fun spawn(type: String, location: Location)
}