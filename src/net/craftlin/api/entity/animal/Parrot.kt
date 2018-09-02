package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity
import net.craftlin.api.value.entity.ParrotVariant

interface Parrot: GrowingEntity, TameableEntity {
    /** @see ParrotVariant */
    var variant: String
}