package net.craftlin.api.entity.base

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.animal.Wolf
import net.craftlin.api.entity.animal.Parrot

/**
 * Represents an tameable entity, such as [Wolf] or [Parrot]
 */
interface TameableEntity: LivingEntity {

    /** Whether the entity is tamed or not */
    val tamed get() = owner != null
    /** The owner of the entity (or null when not tamed) */
    var owner: OfflinePlayer?

}