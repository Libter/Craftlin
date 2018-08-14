package net.craftlin.plugin.api.value

import kotlin.reflect.KProperty

class EnumDelegate<T>(private var enum: EnumValue<T>, private var origin: T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return enum.toString(origin)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        origin = enum.fromString(value)
    }
}