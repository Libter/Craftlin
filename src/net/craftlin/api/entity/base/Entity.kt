package net.craftlin.api.entity.base

import net.craftlin.api.world.Location

/**
 * Represents an Minecraft entity.
 */
interface Entity {

    /** Unique ID */
    val uuid: String
    /** Entity's custom name or player's name */
    var name: String
    /** Location, set it to teleport */
    var location: Location

}