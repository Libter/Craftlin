package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.base.Entity
import net.craftlin.plugin.api.world.Location
import net.craftlin.plugin.bukkit.extension.toBukkitLocation
import net.craftlin.plugin.bukkit.impl.world.BukkitLocation
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity

abstract class BukkitEntity(private val origin: LivingEntity): Entity {
    override val uuid: String = origin.uniqueId.toString()
    override val location: Location
        get() = BukkitLocation(origin.location)
    override var customName: String
        get() = origin.customName
        set(value) { origin.customName = value }
    override var health: Int
        get() = origin.health.toInt()
        set(value) { origin.health = value.toDouble() }
    override var maxHealth: Int
        get() = origin.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue.toInt()
        set(value) { origin.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue = value.toDouble() }
    override var isDead: Boolean
        get() = origin.isDead
        set(value) { if(!origin.isDead && value) origin.health = 0.0}
    override var canPickupItems: Boolean
        get() = origin.canPickupItems
        set(value) { origin.canPickupItems = value }
    override var isCollidable: Boolean
        get() = origin.isCollidable
        set(value) { origin.isCollidable = value }

    override fun teleport(location: Location) {
        origin.teleport(location.toBukkitLocation())
    }

    override fun teleport(entity: Entity) {
        teleport(entity.location)
    }

    override fun ignite(ticks: Int) {
        origin.fireTicks = ticks
    }

    override fun igniteTime(): Int = origin.fireTicks

    override fun damage(amount: Int) = origin.damage(amount.toDouble())
}