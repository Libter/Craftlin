package net.craftlin.api.value

class Effect(
    val type: String,
    var time: Long,
    var strength: Long = 1,
    var ambient: Boolean = false,
    var particles: Boolean = true,
    var icon: Boolean = true
): Cloneable {

    fun copy(newTime: Long) = clone().apply { time = newTime }

}