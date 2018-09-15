package net.craftlin.api.world

import net.craftlin.api.entity.DroppedItem
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.base.Entity
import net.craftlin.api.inventory.Item
import net.craftlin.api.value.world.WorldDifficulty
import net.craftlin.api.value.world.WorldType
import net.craftlin.api.world.block.Block
import kotlin.reflect.KClass

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
    /** The world's difficulty
     * @see WorldDifficulty
     */
    val difficulty: String
    /** Players that are staying in the world */
    val players: List<Player>

    /** @return [Block] at specified position */
    fun blockAt(x: Long, y: Long, z: Long): Block
    /** @return [Block] at specified position */
    fun blockAt(location: Location) = blockAt(location.blockX, location.blockY, location.blockZ)

    /** Spawns mob of [type] at specified [location] */
    fun <T: Entity> spawn(type: KClass<T>, location: Location): T
    /** Drops [item] at specified [location] */
    fun drop(item: Item, location: Location): DroppedItem
}