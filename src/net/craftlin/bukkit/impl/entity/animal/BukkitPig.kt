package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Pig
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity

class BukkitPig(val origin: org.bukkit.entity.Pig): BukkitGrowingEntity(origin), Pig {
    override var saddled: Boolean
        get() = origin.hasSaddle()
        set(value) { origin.setSaddle(value) }
}