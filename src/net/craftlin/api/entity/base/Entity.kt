package net.craftlin.api.entity.base

import net.craftlin.api.world.Location
import net.craftlin.api.world.World

/**
 * Represents an Minecraft entity.
 */
interface Entity {

    /** Unique ID */
    val uuid: String
    /** Immutable type */
    val type: String
    /** Entity's custom name or player's name */
    var name: String
    /** Location, set it to teleport */
    var location: Location
    /** World computed from location */
    val world: World get() = location.world

    fun distance2D(other: Location) = location.distance2D(other)
    fun distance3D(other: Location) = location.distance3D(other)

    fun distance2D(entity: Entity) = distance2D(entity.location)
    fun distance3D(entity: Entity) = distance3D(entity.location)

}