package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.GrowingEntity
import org.bukkit.entity.Ageable

abstract class BukkitGrowingEntity(protected val ageable: Ageable): BukkitLivingEntity(ageable), GrowingEntity {

    override var baby: Boolean
        get() = !ageable.isAdult
        set(value) { if (value) ageable.setBaby() else ageable.setAdult() }
}