package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.Entity
import net.craftlin.bukkit.impl.value.BukkitEntityType
import net.craftlin.bukkit.impl.world.BukkitLocation
import org.bukkit.Location

open class BukkitEntity(protected val entity: org.bukkit.entity.Entity): Entity {
    private var originLocation: Location
        get() = entity.location
        set(value) { entity.teleport(value) }

    override val uuid: String = entity.uniqueId.toString()
    override val type: String = BukkitEntityType.Converter(entity.type)
    override var name: String
        get() = entity.customName
        set(value) { entity.customName = value }
    override var location by BukkitLocation.Delegate(::originLocation)
}