package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.AgeableEntity

interface Woolf: AgeableEntity {
    var collarColor: String
    var angry: Boolean
}