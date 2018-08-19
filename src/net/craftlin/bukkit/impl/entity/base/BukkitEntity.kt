package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.Entity
import net.craftlin.api.world.Location
import net.craftlin.bukkit.extension.toBukkitLocation
import net.craftlin.bukkit.impl.world.BukkitLocation
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity

abstract class BukkitEntity(protected val entity: LivingEntity): Entity {
    override val uuid: String = entity.uniqueId.toString()
    override val location: Location
        get() = BukkitLocation(entity.location)
    override var customName: String
        get() = entity.customName
        set(value) { entity.customName = value }
    override var health: Int
        get() = entity.health.toInt()
        set(value) { entity.health = value.toDouble() }
    override var maxHealth: Int
        get() = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue.toInt()
        set(value) { entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue = value.toDouble() }
    override var isDead: Boolean
        get() = entity.isDead
        set(value) { if(!entity.isDead && value) entity.health = 0.0}
    override var canPickupItems: Boolean
        get() = entity.canPickupItems
        set(value) { entity.canPickupItems = value }
    override var isCollidable: Boolean
        get() = entity.isCollidable
        set(value) { entity.isCollidable = value }

    override fun teleport(location: Location) {
        entity.teleport(location.toBukkitLocation())
    }

    override fun teleport(entity: Entity) {
        teleport(entity.location)
    }

    override fun ignite(ticks: Int) {
        entity.fireTicks = ticks
    }

    override fun igniteTime(): Int = entity.fireTicks

    override fun damage(amount: Int) = entity.damage(amount.toDouble())
}