package net.craftlin.plugin.api

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.world.World

interface Server {
    val players: List<Player>
    val worlds: List<World>
}