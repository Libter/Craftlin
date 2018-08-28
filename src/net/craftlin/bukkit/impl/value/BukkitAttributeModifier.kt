package net.craftlin.bukkit.impl.value

import net.craftlin.api.value.AttributeModifier
import org.bukkit.attribute.AttributeInstance
import org.bukkit.attribute.AttributeModifier.Operation

class BukkitAttributeModifier(private val instance: AttributeInstance, private val name: String): AttributeModifier {

    private fun raw(rawValue: Double, operation: Operation) {
        val modifier = org.bukkit.attribute.AttributeModifier(name, rawValue, operation)
        if (instance.modifiers.removeIf { it.name == name && it != modifier }) {
            instance.addModifier(modifier)
        }
    }

    override fun plusAssign(value: Double) = raw(value, Operation.ADD_NUMBER)

    override fun minusAssign(value: Double) = plusAssign(-value)

    override fun timesAssign(value: Double) = raw(value - 1, Operation.MULTIPLY_SCALAR_1)

    override fun divAssign(value: Double) = timesAssign(1 / value)
}