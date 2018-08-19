package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Woolf
import net.craftlin.bukkit.impl.entity.base.BukkitAgeableEntity
import net.craftlin.bukkit.impl.value.BukkitDyeColor

class BukkitWoolf(val origin: org.bukkit.entity.Wolf): BukkitAgeableEntity(origin), Woolf {
    private var originCollarColor: org.bukkit.DyeColor
        get() = origin.collarColor
        set(value) { origin.collarColor = value }

    override var collarColor by BukkitDyeColor.Delegate(::originCollarColor)
    override var angry: Boolean
        get() = origin.isAngry
        set(value) { origin.isAngry = value }

}