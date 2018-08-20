package net.craftlin.api.entity.base

import net.craftlin.api.value.Ignition

interface LivingEntity: Entity {

    var health: Int
    var maxHealth: Int
    val ignition: Ignition
    var dead: Boolean

    var canPickup: Boolean
    var canCollide: Boolean

    //TODO: create value.Effect class and val effects: Collection<Effect>
    fun effect(type: String, time: Long, strength: Long = 1,
           ambient: Boolean = false, particles: Boolean = true, icon: Boolean = true)
    fun damage(amount: Int)

}