package net.craftlin.plugin.bukkit.impl.entity.base

import net.craftlin.plugin.api.entity.base.AgeableEntity
import org.bukkit.entity.Ageable

abstract class BukkitAgeableEntity(protected val ageable: Ageable): BukkitEntity(ageable), AgeableEntity {
    override var adult: Boolean
        get() = ageable.isAdult
        set(value) {
            if (value && !ageable.isAdult)
                ageable.setAdult()
            if (!value && ageable.isAdult)
                ageable.setBaby()
        }
    override var baby: Boolean
        get() = !ageable.isAdult
        set(value) {
            if (value && ageable.isAdult)
                ageable.setBaby()
            if (!value && !ageable.isAdult)
                ageable.setAdult()
        }
}