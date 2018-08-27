package net.craftlin.api.value

data class Ignition(var time: Long) {
    val exists get() = time > 0
    fun remove() { time = 0 }
}