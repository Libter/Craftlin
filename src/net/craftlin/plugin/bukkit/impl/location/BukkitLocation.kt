package net.craftlin.plugin.bukkit.impl.location

import net.craftlin.plugin.api.location.Location
import net.craftlin.plugin.api.location.World

class BukkitLocation(origin: org.bukkit.Location) : Location() {
    override val x = origin.x
    override val y = origin.y
    override val z = origin.z
    override val blockX = x.toInt()
    override val blockY = y.toInt()
    override val blockZ = z.toInt()
    override val pitch = origin.pitch
    override val yaw: Float = origin.yaw
    override val world: World = BukkitWorld(origin.world)
  }