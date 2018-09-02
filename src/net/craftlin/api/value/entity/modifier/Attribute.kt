package net.craftlin.api.value.entity.modifier

interface Attribute {

    val value: Double
    val base: Double

    operator fun invoke(name: String): AttributeModifier

}