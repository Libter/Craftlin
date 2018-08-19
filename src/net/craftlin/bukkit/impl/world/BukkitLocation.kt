package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.Location
import net.craftlin.api.world.World
import org.bukkit.Bukkit

class BukkitLocation(val origin: org.bukkit.Location): Location {

    override var x
        get() = origin.x
        set(value) { origin.x = value }
    override var y
        get() = origin.y
        set(value) { origin.y = value }
    override var z
        get() = origin.z
        set(value) { origin.z = value }

    override var pitch
        get() = origin.pitch.toDouble()
        set(value) { origin.pitch = value.toFloat() }

    override var yaw
        get() = origin.yaw.toDouble()
        set(value) { origin.yaw = value.toFloat() }

    override var world: World
        get() = BukkitWorld(origin.world)
        set(value) { origin.world = Bukkit.getWorld(value.name) }

}