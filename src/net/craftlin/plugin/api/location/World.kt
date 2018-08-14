package net.craftlin.plugin.api.location

import net.craftlin.plugin.api.entity.Player

abstract class World {

    abstract val name: String
    abstract val players: List<Player>

    abstract fun blockAt(location: Location): Block

}