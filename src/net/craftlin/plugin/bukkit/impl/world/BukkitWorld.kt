package net.craftlin.plugin.bukkit.impl.world

import net.craftlin.plugin.api.world.World
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.plugin.bukkit.impl.value.BukkitWorldType

class BukkitWorld(private val origin: org.bukkit.World): World() {
    override val type = BukkitWorldType.Converter(origin.environment)
    override val name: String = origin.name
    override val players = origin.players.map { BukkitPlayer(it) }

    override fun blockAt(x: Int, y: Int, z: Int) = BukkitBlock(origin.getBlockAt(x, y, z))
}