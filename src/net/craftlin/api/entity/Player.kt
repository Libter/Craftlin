package net.craftlin.api.entity

import net.craftlin.api.entity.base.LivingEntity
import net.craftlin.api.value.GameMode
import net.craftlin.api.world.Sound

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

    /** Plays [sound] to player */
    fun sound(sound: Sound)
    /**
     * Plays sound to player
     *
     * @param type
     * @param volume
     * @param pitch
     *
     * */
    fun sound(type: String, volume: Double = 1.0, pitch: Double = 1.0) = sound(Sound(type, volume, pitch))
}