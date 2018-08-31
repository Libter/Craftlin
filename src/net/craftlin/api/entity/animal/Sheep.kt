package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity

interface Sheep: GrowingEntity {
    /** Whether the sheep is sheared or not */
    var sheared: Boolean
}