package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.LivingEntity
import net.craftlin.api.value.Effect
import net.craftlin.api.value.Ignition
import net.craftlin.bukkit.impl.value.BukkitEffectType
import org.bukkit.potion.PotionEffect

abstract class BukkitLivingEntity(private val livingEntity: org.bukkit.entity.LivingEntity): BukkitEntity(livingEntity), LivingEntity {
    override var health: Int
        get() = livingEntity.health.toInt()
        set(value) { livingEntity.health = value.toDouble() }
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

    override val effects: Collection<Effect>
        get() = livingEntity.activePotionEffects.map {
            Effect(it.type, it.duration.toLong(), it.amplifier.toLong(), it.isAmbient, it.hasParticles(), it.hasIcon())
        }

    override fun effect(effect: Effect) {
        livingEntity.addPotionEffect(with(effect) {
            PotionEffect(originType, time.toInt(), strength.toInt(), ambient, particles, icon)
        })
    }

    override fun damage(amount: Int) { livingEntity.damage(amount.toDouble()) }
}