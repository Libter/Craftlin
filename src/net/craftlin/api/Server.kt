package net.craftlin.api

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.Sender
import net.craftlin.api.misc.itF
import net.craftlin.api.world.World

/**
 * Represents a Minecraft server.
 */
interface Server {
    /** List of online players. */
    val players: List<Player>
    /** List of server's worlds. */
    val worlds: List<World>

    /** Retrieves an online player with specified [name] or returns null */
    fun player(name: String): Player?

    /** Server's console */
    val console: Sender

    /**
     * Retrieves an offline player with specified [name]. This function is asynchronous.
     *
     * @param callback A function that takes an OfflinePlayer as a parameter.
     */
    fun offlinePlayer(name: String, callback: itF<OfflinePlayer?>)
}