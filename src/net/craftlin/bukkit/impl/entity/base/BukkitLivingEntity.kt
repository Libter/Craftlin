package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.LivingEntity
import net.craftlin.api.value.Ignition
import org.bukkit.attribute.Attribute

abstract class BukkitLivingEntity(private val livingEntity: org.bukkit.entity.LivingEntity): BukkitEntity(livingEntity), LivingEntity {
    override var health: Int
        get() = livingEntity.health.toInt()
        set(value) { livingEntity.health = value.toDouble() }
    override var maxHealth: Int
        get() = livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue.toInt()
        set(value) { livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue = value.toDouble() }
    override val ignition: Ignition
        get() = Ignition(livingEntity.fireTicks.toLong())
    override var dead: Boolean
        get() = livingEntity.isDead
        set(value) {
            if (!value && !livingEntity.isDead) health = 0
        }
    override var canPickup: Boolean
        get() = livingEntity.canPickupItems
        set(value) { livingEntity.canPickupItems = value }
    override var canCollide: Boolean
        get() = livingEntity.isCollidable
        set(value) { livingEntity.isCollidable = value }

    override fun effect(type: String, time: Long, strength: Long, ambient: Boolean, particles: Boolean, icon: Boolean) {
        //TODO implement
    }

    override fun damage(amount: Int) { livingEntity.damage(amount.toDouble()) }
}