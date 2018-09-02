package net.craftlin.bukkit.impl.value

import net.craftlin.api.value.entity.modifier.AttributeModifier
import org.bukkit.attribute.AttributeInstance
import org.bukkit.attribute.AttributeModifier.Operation

class BukkitAttributeModifier(private val instance: AttributeInstance, private val name: String): AttributeModifier {

    private fun raw(suffix: String, rawValue: Double, operation: Operation) {
        val localName = "$name-$suffix"
        val modifier = org.bukkit.attribute.AttributeModifier(localName, rawValue, operation)
        var equals = false
        instance.modifiers.removeIf {
            equals = equals || it == modifier;
            it.name == localName && it != modifier
        }
        if (!equals) {
            instance.addModifier(modifier)
        }
    }

    override fun remove() {
        instance.modifiers.removeIf { it.name.startsWith(name) }
    }

    override fun plusAssign(value: Double) = raw("plus", value, Operation.ADD_NUMBER)

    override fun minusAssign(value: Double) = raw("minus", -value, Operation.ADD_NUMBER)

    override fun timesAssign(value: Double) = raw("times", value - 1, Operation.MULTIPLY_SCALAR_1)

    override fun divAssign(value: Double) = raw("div", (1 / value) - 1, Operation.MULTIPLY_SCALAR_1)
}