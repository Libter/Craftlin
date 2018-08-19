package net.craftlin.plugin.api.util

class BiHashMap<K, V> {

    private val byKey = HashMap<K, V>()
    private val byValue = HashMap<V, K>()

    operator fun set(key: K, value: V) {
        byKey[key] = value
        byValue[value] = key
    }

    fun byKey(key: K) = byKey[key]
    fun byValue(value: V) = byValue[value]

}