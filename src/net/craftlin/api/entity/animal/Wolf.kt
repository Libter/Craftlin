package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity

interface Wolf: GrowingEntity, TameableEntity {
    var collarColor: String
    var angry: Boolean
}