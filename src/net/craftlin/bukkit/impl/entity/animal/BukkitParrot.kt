package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Parrot
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity
import net.craftlin.bukkit.impl.value.BukkitParrotType

class BukkitParrot(private val origin: org.bukkit.entity.Parrot): BukkitGrowingEntity(origin), Parrot {
    private var originType: org.bukkit.entity.Parrot.Variant
        get() = origin.variant
        set(value) { origin.variant = value }

    override var type by BukkitParrotType.Delegate(::originType)
}