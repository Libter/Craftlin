package net.craftlin.plugin.api.world

import net.craftlin.plugin.api.entity.Player

abstract class World {
    abstract val name: String
    abstract val type: String
    abstract val players: List<Player>

    abstract fun blockAt(x: Int, y: Int, z: Int): Block
    fun blockAt(location: Location) = blockAt(location.blockX, location.blockY, location.blockZ)
}