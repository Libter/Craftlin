package net.craftlin.plugin.api.world

import net.craftlin.plugin.api.entity.Player

interface World {
    val name: String
    val type: String
    val players: List<Player>

    fun blockAt(x: Int, y: Int, z: Int): Block
    fun blockAt(location: Location) = blockAt(location.blockX, location.blockY, location.blockZ)
}