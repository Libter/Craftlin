package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity

interface Sheep: GrowingEntity {
    var sheared: Boolean
}