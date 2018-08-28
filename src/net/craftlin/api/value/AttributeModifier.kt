package net.craftlin.api.value

interface AttributeModifier {

    fun remove()
    operator fun plusAssign(value: Double)
    operator fun minusAssign(value: Double)
    operator fun timesAssign(value: Double)
    operator fun divAssign(value: Double)

}