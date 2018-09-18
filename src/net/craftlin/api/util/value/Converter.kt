package net.craftlin.api.util.value

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.isAccessible

abstract class Converter<Api: Any, Impl: Any> {

    abstract fun toImpl(value: Api): Impl
    abstract fun toApi(origin: Impl): Api

    inner class Delegate(private val origin: KMutableProperty<Impl>) {
        init {
            origin.getter.isAccessible = true
            origin.setter.isAccessible = true
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): Api {
            return toApi(origin.getter.call())
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Api) {
            origin.setter.call(toImpl(value))
        }
    }

}