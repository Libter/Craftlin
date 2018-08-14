package net.craftlin.plugin.api.value.base

import kotlin.reflect.KProperty

class SimpleDelegate<T>(private var origin: T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return origin
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        origin = value
    }
}