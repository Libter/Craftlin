package net.craftlin.api.entity.base

import net.craftlin.api.value.Attribute
import net.craftlin.api.value.Effect
import net.craftlin.api.value.EntitySpeed
import net.craftlin.api.value.Ignition

interface LivingEntity: Entity {

    val speed: EntitySpeed
    val maxHealth: Attribute

    var health: Int
    val ignition: Ignition
    var dead: Boolean

    var canPickup: Boolean
    var canCollide: Boolean

    val effects: Collection<Effect>
    fun effect(effect: Effect)
    fun effect(type: String, time: Long, strength: Long = 1, ambient: Boolean = false, particles: Boolean = true, icon: Boolean = true)
        = effect(Effect(type, time, strength, ambient, particles, icon))
    fun damage(amount: Int)

}