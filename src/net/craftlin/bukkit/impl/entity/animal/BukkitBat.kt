package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Bat
import net.craftlin.bukkit.impl.entity.base.BukkitEntity

class BukkitBat(val origin: org.bukkit.entity.Bat): BukkitEntity(origin), Bat {
    override var awaked: Boolean
        get() = origin.isAwake
        set(value) { origin.isAwake = value }
}