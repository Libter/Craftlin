package net.craftlin.plugin.api.entity.animal

import net.craftlin.plugin.api.entity.base.AgeableEntity

interface Sheep: AgeableEntity {
    var sheared: Boolean
}