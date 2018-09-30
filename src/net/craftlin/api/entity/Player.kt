package net.craftlin.api.entity

import net.craftlin.api.entity.base.LivingEntity
import net.craftlin.api.value.GameMode

/**
 * Represents an online player.
 */
interface Player: OfflinePlayer, LivingEntity, Sender {
    /** Player's gamemode. For possible values, check [GameMode] */
    var gamemode: String

    /** Kicks player from the server for specified [reason] **/
    fun kick(reason: String)

    /** Checks if player has a specific permission */
    fun permitted(permission: String): Boolean
}