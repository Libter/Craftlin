package net.craftlin.bukkit.impl.world

import net.craftlin.api.world.block.Door
import net.craftlin.bukkit.impl.value.BukkitDoorHinge

class BukkitDoor(origin: org.bukkit.block.Block): BukkitBlock(origin), Door {
    private val door = origin.blockData as org.bukkit.block.data.type.Door
    private var originHinge: org.bukkit.block.data.type.Door.Hinge
        get() = door.hinge
        set(value) { door.hinge = value }
    override val hinge by BukkitDoorHinge.Delegate(::originHinge)
    override var opened: Boolean
        get() = door.isOpen
        set(value) { door.isOpen = value }
}