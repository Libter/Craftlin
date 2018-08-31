package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.value.RabbitType

interface Rabbit: GrowingEntity {
    /** @see RabbitType */
    var type: String
}