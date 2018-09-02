package net.craftlin.api.entity.base

import net.craftlin.api.value.entity.modifier.Attribute
import net.craftlin.api.value.entity.modifier.Effect
import net.craftlin.api.value.entity.modifier.EffectType
import net.craftlin.api.value.entity.modifier.EntitySpeed
import net.craftlin.api.value.entity.modifier.Ignition

/**
 * Represents a living entity.
 */
interface LivingEntity: Entity {

    /** Entity's speed */
    val speed: EntitySpeed
    /** Entity's max health */
    val maxHealth: Attribute

    /** Entity's current health */
    var health: Long
    /** Entity's ignition data */
    val ignition: Ignition
    /** Whether entity is dead or not */
    var dead: Boolean

    /** Whether the entity can pickup items or not */
    var canPickup: Boolean
    /** Whether the entity can collide with other entities or not */
    var canCollide: Boolean

    /** List of current entity's effects */
    val effects: Collection<Effect>
    /** Applies an [effect] to an entity */
    fun effect(effect: Effect)

    /**
     * Applies an effect to an entity.
     *
     * @param type see [EffectType]
     * @param time Effect duration in ticks
     * @param strength Effect strength (from 1 to 255)
     * @param ambient Whether the effect should be more translucent or not (used by beacons)
     * @param particles Whether the particles should be visible or not
     * @param icon Whether the icon should be visible for player or not
     */
    fun effect(type: String, time: Long, strength: Long = 1, ambient: Boolean = false, particles: Boolean = true, icon: Boolean = true)
        = effect(Effect(type, time, strength, ambient, particles, icon))
    fun damage(amount: Long)

}