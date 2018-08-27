package net.craftlin.api.entity.base

import net.craftlin.api.entity.OfflinePlayer

interface TameableEntity: LivingEntity {

    val tamed get() = owner != null
    var owner: OfflinePlayer?

}