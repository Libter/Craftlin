package net.craftlin.plugin.api.value

//For simplicity scripts will use strings instead enums
abstract class EnumValue<T> {
    protected abstract val values: Map<String, T>
    private val keys: Map<T, String> by lazy {
        val map = HashMap<T, String>()
        values.forEach { k, v -> map[v] = k}
        map
    }

    fun fromString(value: String): T = values[value.toLowerCase().replace("_", " ")] ?: throw IllegalArgumentException()
    fun toString(value: T): String = keys[value] ?: throw NotImplementedError()

}