package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.value.entity.modifier.EntitySpeed
import net.craftlin.bukkit.impl.value.BukkitAttribute
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity

class BukkitEntitySpeed(origin: LivingEntity): EntitySpeed {
    override val move = BukkitAttribute(origin, Attribute.GENERIC_MOVEMENT_SPEED)
    override val fly = BukkitAttribute(origin, Attribute.GENERIC_FLYING_SPEED)
    override val attack = BukkitAttribute(origin, Attribute.GENERIC_ATTACK_SPEED)
}