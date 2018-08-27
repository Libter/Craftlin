package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Ocelot
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity
import net.craftlin.bukkit.impl.entity.base.TameableOwner
import net.craftlin.bukkit.impl.value.BukkitOcelotType

class BukkitOcelot(private val origin: org.bukkit.entity.Ocelot): BukkitGrowingEntity(origin), Ocelot {
    private var originType: org.bukkit.entity.Ocelot.Type
        get() = origin.catType
        set(value) { origin.catType = value }

    override var type by BukkitOcelotType.Delegate(::originType)

    override var owner by TameableOwner(origin)
}