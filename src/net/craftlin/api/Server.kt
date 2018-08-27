package net.craftlin.api

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.misc.itF
import net.craftlin.api.world.World

interface Server {
    val players: List<Player>
    val worlds: List<World>

    fun player(name: String): Player?
    fun offlinePlayer(name: String, callback: itF<OfflinePlayer>)
}