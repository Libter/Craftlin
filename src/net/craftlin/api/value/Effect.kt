package net.craftlin.api.value

/**
 * Represents an effect applicable to entities
 */
open class Effect(
    var type: String,
    var time: Long,
    var strength: Int = 1,
    var ambient: Boolean = false,
    var particles: Boolean = true,
    var icon: Boolean = true
): Cloneable {

    fun copy(newTime: Long) = clone().apply { time = newTime }

}