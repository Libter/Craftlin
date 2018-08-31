package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity
import net.craftlin.api.value.ParrotType

interface Parrot: GrowingEntity, TameableEntity {
    /** @see ParrotType */
    var type: String
}