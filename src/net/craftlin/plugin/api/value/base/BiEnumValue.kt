package net.craftlin.plugin.api.value.base

import net.craftlin.plugin.util.BiHashMap
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.isAccessible

abstract class BiEnumValue<Api: Enum<*>, Impl>(private val apiClass: KClass<Api>) {

    inner class Delegate(private var origin: KMutableProperty<Impl>) {
        init {
            origin.getter.isAccessible = true
            origin.setter.isAccessible = true
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return apiMap.byValue(toApi(origin.getter.call())) ?: throw NotImplementedError()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            origin.setter.call(toImpl(apiMap.byKey(value) ?: throw IllegalArgumentException()))
        }
    }

    protected abstract fun toImpl(api: Api): Impl
    protected abstract fun toApi(impl: Impl): Api

    private val apiMap by lazy {
        val map = BiHashMap<String, Api>()
        (apiClass.java.enumConstants as Array<out Api>).forEach {
            map[it.name.toLowerCase().replace('_', ' ')] = it
        }
        map
    }
}