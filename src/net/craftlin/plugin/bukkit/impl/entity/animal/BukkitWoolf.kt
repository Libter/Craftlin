package net.craftlin.plugin.bukkit.impl.entity.animal

import net.craftlin.plugin.api.entity.animal.Woolf
import net.craftlin.plugin.bukkit.impl.entity.base.BukkitAgeableEntity
import net.craftlin.plugin.bukkit.impl.value.BukkitDyeColor

class BukkitWoolf(val origin: org.bukkit.entity.Wolf): BukkitAgeableEntity(origin), Woolf {
    private var originCollarColor: org.bukkit.DyeColor
        get() = origin.collarColor
        set(value) { origin.collarColor = value }

    override var collarColor by BukkitDyeColor.Delegate(::originCollarColor)
    override var angry: Boolean
        get() = origin.isAngry
        set(value) { origin.isAngry = value }

}