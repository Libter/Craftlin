package net.craftlin.plugin.api.value

//For simplicity scripts will use strings instead enums
abstract class EnumValue<T> {
    protected abstract val values: Map<String, T>
    private val keys = HashMap<T, String>()

    init {
        values.forEach { keys[it.value] = it.key }
    }

    fun fromString(value: String): T = values[value] ?: throw IllegalArgumentException()
    fun toString(value: T): String = keys[value] ?: throw NotImplementedError()
}