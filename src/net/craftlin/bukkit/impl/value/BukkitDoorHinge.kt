package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.world.DoorHinge
import org.bukkit.block.data.type.Door

object BukkitDoorHinge: EnumValue<DoorHinge, Door.Hinge>(DoorHinge::class) {
    override fun convert(api: DoorHinge) = when (api) {
        DoorHinge.LEFT -> Door.Hinge.LEFT
        DoorHinge.RIGHT -> Door.Hinge.RIGHT
    }
}