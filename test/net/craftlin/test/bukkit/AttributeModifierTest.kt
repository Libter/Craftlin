package net.craftlin.test.bukkit

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import net.craftlin.bukkit.impl.value.BukkitAttributeModifier
import org.bukkit.attribute.AttributeInstance
import org.bukkit.attribute.AttributeModifier
import org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER
import org.bukkit.attribute.AttributeModifier.Operation.MULTIPLY_SCALAR_1
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AttributeModifierTest {

    val delta = 0.001
    val modifiers = ArrayList<AttributeModifier>()
    val instance: AttributeInstance = mock {
        on { addModifier(any()) } doAnswer {
            modifiers.add(it.arguments[0] as AttributeModifier)
            Unit
        }
        on { modifiers } doReturn modifiers
    }
    val value: Double get() {
        var ret = 1.0
        modifiers.forEach {
            when (it.operation) {
                ADD_NUMBER -> ret += it.amount
                MULTIPLY_SCALAR_1 -> ret *= 1 + it.amount
                else -> Unit
            }
        }
        return ret
    }

    @Before
    fun cleanup() = modifiers.clear()

    @Test
    fun simpleTest() {
        val modifier = BukkitAttributeModifier(instance, "test")
        modifier += 1.5
        assertEquals(2.5, value, delta)
        modifier *= 2.0
        assertEquals(5.0, value, delta)
    }

    @Test
    fun allModifiersTest() {
        val modifier = BukkitAttributeModifier(instance, "test")
        modifier += 1.0
        assertEquals(2.0, value, delta)
        modifier -= 1.0
        assertEquals(1.0, value, delta)
        modifier *= 3.14
        assertEquals(3.14, value, delta)
        modifier /= 3.14
        assertEquals(1.0, value, delta)
    }

    @Test
    fun multiModifiersTest() {
        val modifier1 = BukkitAttributeModifier(instance, "test1")
        val modifier2 = BukkitAttributeModifier(instance, "test2")
        modifier1 += 1.0
        modifier2 += 1.5
        assertEquals(value, 3.5, delta)
    }

    @Test
    fun removalTest() {
        val modifier = BukkitAttributeModifier(instance, "test")
        modifier += 1.0
        modifier -= 2.0
        modifier *= 3.0
        modifier /= 4.0
        modifier.remove()
        assertEquals(value, 1.0, delta)
    }

}