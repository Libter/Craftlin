package net.craftlin.api.world

import net.craftlin.api.entity.Player

interface World {
    val name: String
    val type: String
    val players: List<Player>

    fun blockAt(x: Int, y: Int, z: Int): Block
    fun blockAt(location: Location) = blockAt(location.blockX, location.blockY, location.blockZ)
    fun spawnMob(type: String, location: Location)
}