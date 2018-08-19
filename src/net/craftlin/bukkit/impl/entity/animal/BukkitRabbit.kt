package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Rabbit
import net.craftlin.bukkit.impl.entity.base.BukkitAgeableEntity
import net.craftlin.bukkit.impl.value.BukkitRabbitType

class BukkitRabbit(val origin: org.bukkit.entity.Rabbit): BukkitAgeableEntity(origin), Rabbit {
    private var originType: org.bukkit.entity.Rabbit.Type
        get() = origin.rabbitType
        set(value) { origin.rabbitType = value }

    override var type by BukkitRabbitType.Delegate(::originType)
}