package net.craftlin.api.value.entity.modifier

/** Represents an attribute modifier */
interface AttributeModifier {

    /** Removes the modifier */
    fun remove()
    /** Increments value by [value]*/
    operator fun plusAssign(value: Double)
    /** Decrements value by [value]*/
    operator fun minusAssign(value: Double)
    /** Multiplies value by [value]*/
    operator fun timesAssign(value: Double)
    /** Divides value by [value]*/
    operator fun divAssign(value: Double)

}