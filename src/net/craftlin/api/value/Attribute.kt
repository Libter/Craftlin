package net.craftlin.api.value

interface Attribute {

    val value: Double
    val base: Double

    operator fun invoke(name: String): AttributeModifier

}