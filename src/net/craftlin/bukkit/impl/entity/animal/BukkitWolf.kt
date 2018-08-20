package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Wolf
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity
import net.craftlin.bukkit.impl.value.BukkitDyeColor

class BukkitWolf(val origin: org.bukkit.entity.Wolf): BukkitGrowingEntity(origin), Wolf {
    private var originCollarColor: org.bukkit.DyeColor
        get() = origin.collarColor
        set(value) { origin.collarColor = value }

    override var collarColor by BukkitDyeColor.Delegate(::originCollarColor)
    override var angry: Boolean
        get() = origin.isAngry
        set(value) { origin.isAngry = value }

}