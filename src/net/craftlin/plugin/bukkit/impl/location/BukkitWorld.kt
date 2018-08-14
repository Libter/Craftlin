package net.craftlin.plugin.bukkit.impl.location

import net.craftlin.plugin.api.location.Location
import net.craftlin.plugin.api.location.World
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer

class BukkitWorld(val origin: org.bukkit.World): World() {
    override val name = origin.name
    override val players = origin.players.map { BukkitPlayer(it) }

    override fun blockAt(location: Location) = BukkitBlock(origin.getBlockAt(location.blockX, location.blockY, location.blockZ))
}