package net.craftlin.bukkit.impl.world

import net.craftlin.api.util.value.Converter
import net.craftlin.api.world.Location
import org.bukkit.Bukkit

object BukkitLocation: Converter<Location, org.bukkit.Location>() {

    override fun toImpl(value: Location) = org.bukkit.Location(
        Bukkit.getWorld(value.world.name),
        value.x, value.y, value.z,
        value.yaw.toFloat(), value.pitch.toFloat()
    )

    override fun toApi(origin: org.bukkit.Location) = Location(
        world = BukkitWorld(origin.world),
        x = origin.x, y = origin.y, z = origin.z,
        yaw = origin.yaw.toDouble(), pitch = origin.pitch.toDouble()
    )

}