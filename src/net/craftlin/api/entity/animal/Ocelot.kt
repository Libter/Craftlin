package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity
import net.craftlin.api.value.OcelotType

interface Ocelot: GrowingEntity, TameableEntity {
    /** @see OcelotType */
    var type: String
}