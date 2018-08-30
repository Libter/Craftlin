package net.craftlin.bukkit.impl.value

import net.craftlin.api.value.Attribute
import org.bukkit.entity.LivingEntity

class BukkitAttribute(private val origin: LivingEntity, private val type: org.bukkit.attribute.Attribute): Attribute {

    private val instance get() = origin.getAttribute(type)

    override val value get() = instance.value
    override val base get() = instance.baseValue
    override fun invoke(name: String) = BukkitAttributeModifier(instance, name)

}