package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.value.entity.RabbitVariant

interface Rabbit: GrowingEntity {
    /** @see RabbitVariant */
    var variant: String
}