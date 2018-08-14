package net.craftlin.plugin.bukkit.impl.location

import net.craftlin.plugin.api.location.World
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer

class BukkitWorld(private val origin: org.bukkit.World): World() {
    override val name: String = origin.name
    override val players = origin.players.map { BukkitPlayer(it) }

    override fun blockAt(x: Int, y: Int, z: Int) = BukkitBlock(origin.getBlockAt(x, y, z))
}