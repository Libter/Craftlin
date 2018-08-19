package net.craftlin.bukkit.extension

import net.craftlin.api.world.Location
import org.bukkit.Bukkit

fun Location.toBukkitLocation(): org.bukkit.Location {
    val world = Bukkit.getWorld(this.world.name) ?: Bukkit.getWorlds()[0]
    return org.bukkit.Location(world, this.x, this.y, this.z)
}