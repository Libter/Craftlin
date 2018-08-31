package net.craftlin.api.entity

import net.craftlin.api.Server

/**
 * Represents an offline player.
 *
 * @see Player
 */
interface OfflinePlayer {
    /** Player's nickname */
    val name: String

    /** Player's unique ID */
    val uuid: String

    /**
     * Is this player online?
     * If yes, you can retrieve a [Player] instance using [Server.player]
     */
    val online: Boolean
}