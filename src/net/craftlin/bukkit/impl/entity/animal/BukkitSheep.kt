package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Sheep
import net.craftlin.bukkit.impl.entity.base.BukkitAgeableEntity

class BukkitSheep(val origin: org.bukkit.entity.Sheep): BukkitAgeableEntity(origin), Sheep {
    override var sheared: Boolean
        get() = origin.isSheared
        set(value) { origin.isSheared = value  }
}