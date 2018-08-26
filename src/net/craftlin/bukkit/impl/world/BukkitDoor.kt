package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.block.Door
import net.craftlin.bukkit.impl.value.BukkitDoorHinge
import org.bukkit.block.Block

class BukkitDoor(private val origin: org.bukkit.block.data.type.Door): BukkitBlock(origin as Block), Door {
    private var originHinge: org.bukkit.block.data.type.Door.Hinge
        get() = origin.hinge
        set(value) { origin.hinge = value }
    override val hinge by BukkitDoorHinge.Delegate(::originHinge)
    override var opened: Boolean
        get() = origin.isOpen
        set(value) { origin.isOpen = value }
}