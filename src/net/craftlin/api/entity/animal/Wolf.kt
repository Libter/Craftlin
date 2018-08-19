package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity

interface Wolf: GrowingEntity {
    var collarColor: String
    var angry: Boolean
}