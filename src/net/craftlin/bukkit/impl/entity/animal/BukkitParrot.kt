package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Parrot
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity
import net.craftlin.bukkit.impl.entity.base.TameableOwner
import net.craftlin.bukkit.impl.value.BukkitParrotType

class BukkitParrot(private val origin: org.bukkit.entity.Parrot): BukkitGrowingEntity(origin), Parrot {
    private var originType: org.bukkit.entity.Parrot.Variant
        get() = origin.variant
        set(value) { origin.variant = value }

    override var variant by BukkitParrotType.Delegate(::originType)

    override var owner by TameableOwner(origin)
}