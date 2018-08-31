package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity

interface Pig: GrowingEntity {
    /** Whether the pig is saddled or not */
    var saddled: Boolean
}