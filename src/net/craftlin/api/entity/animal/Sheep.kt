package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.AgeableEntity

interface Sheep: AgeableEntity {
    var sheared: Boolean
}