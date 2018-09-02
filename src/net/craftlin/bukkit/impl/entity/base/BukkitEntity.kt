package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.Entity
import net.craftlin.api.world.Location
import net.craftlin.bukkit.impl.value.BukkitEntityType
import net.craftlin.bukkit.impl.world.BukkitLocation

open class BukkitEntity(protected val entity: org.bukkit.entity.Entity): Entity {
    override val uuid: String = entity.uniqueId.toString()
    override val type: String = BukkitEntityType.Converter(entity.type)
    override var name: String
        get() = entity.customName
        set(value) { entity.customName = value }
    override var location: Location
        get() = BukkitLocation(entity.location)
        set(value) { if (value is BukkitLocation) entity.teleport(value.origin) }
}