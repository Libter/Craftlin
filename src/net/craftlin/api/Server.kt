package net.craftlin.api

import net.craftlin.api.entity.Player
import net.craftlin.api.world.World

interface Server {
    val players: List<Player>
    val worlds: List<World>
}