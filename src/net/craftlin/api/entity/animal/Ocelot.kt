package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity
import net.craftlin.api.value.entity.OcelotVariant

interface Ocelot: GrowingEntity, TameableEntity {
    /** @see OcelotVariant */
    var variant: String
}