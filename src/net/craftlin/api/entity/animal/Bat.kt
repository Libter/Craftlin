package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.LivingEntity

interface Bat: LivingEntity {
    /** Wheter the bat is awaked or not */
    var awaked: Boolean
}