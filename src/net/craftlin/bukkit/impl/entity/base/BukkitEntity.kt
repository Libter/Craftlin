package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.Entity
import net.craftlin.api.world.Location
import net.craftlin.bukkit.impl.world.BukkitLocation
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity

abstract class BukkitEntity(protected val entity: LivingEntity): Entity {
    override val uuid: String = entity.uniqueId.toString()
    override var name: String
        get() = entity.customName
        set(value) { entity.customName = value }
    override var location: Location
        get() = BukkitLocation(entity.location)
        set(value) { if (value is BukkitLocation) entity.teleport(value.origin) }
}