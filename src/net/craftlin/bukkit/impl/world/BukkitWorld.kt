package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.Location
import net.craftlin.api.world.World
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.value.BukkitEntityType
import net.craftlin.bukkit.impl.value.BukkitWorldType

class BukkitWorld(private val origin: org.bukkit.World): World {
    override val type = BukkitWorldType.Converter(origin.environment)
    override val name: String = origin.name
    override val players get() = origin.players.map { BukkitPlayer(it) }

    override fun blockAt(x: Long, y: Long, z: Long) = BukkitBlock(origin.getBlockAt(x.toInt(), y.toInt(), z.toInt()))
    override fun spawn(type: String, location: Location) {
        origin.spawnEntity((location as BukkitLocation).origin, BukkitEntityType.Converter(type))
    }
}