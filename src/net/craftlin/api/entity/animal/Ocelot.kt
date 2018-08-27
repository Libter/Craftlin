package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity

interface Ocelot: GrowingEntity, TameableEntity {
    var type: String
}