package net.craftlin.plugin.bukkit.impl.entity.animal

import net.craftlin.plugin.api.entity.animal.Bat
import net.craftlin.plugin.api.entity.base.Entity
import net.craftlin.plugin.bukkit.impl.entity.base.BukkitEntity

class BukkitBat(val origin: org.bukkit.entity.Bat): BukkitEntity(origin), Bat {
    override var awake: Boolean
        get() = origin.isAwake
        set(value) { origin.isAwake = value }
}