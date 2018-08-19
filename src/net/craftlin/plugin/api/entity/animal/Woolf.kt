package net.craftlin.plugin.api.entity.animal

import net.craftlin.plugin.api.entity.base.AgeableEntity

interface Woolf: AgeableEntity {
    var collarColor: String
    var angry: Boolean
}