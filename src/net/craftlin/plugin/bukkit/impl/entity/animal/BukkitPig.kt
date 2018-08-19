package net.craftlin.plugin.bukkit.impl.entity.animal

import net.craftlin.plugin.api.entity.animal.Pig
import net.craftlin.plugin.bukkit.impl.entity.base.BukkitAgeableEntity

class BukkitPig(val origin: org.bukkit.entity.Pig): BukkitAgeableEntity(origin), Pig {
    override var saddled: Boolean
        get() = origin.hasSaddle()
        set(value) { origin.setSaddle(value) }
}