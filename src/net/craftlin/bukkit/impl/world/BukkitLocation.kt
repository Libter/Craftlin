package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.Location
import net.craftlin.api.world.World

class BukkitLocation(origin: org.bukkit.Location) : Location {
    override val x = origin.x
    override val y = origin.y
    override val z = origin.z
    override val pitch = origin.pitch
    override val yaw: Float = origin.yaw
    override val world: World = BukkitWorld(origin.world)
}