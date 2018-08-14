package net.craftlin.plugin.api

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.world.World

abstract class Server {

    abstract val players: List<Player>
    abstract val worlds: List<World>

}