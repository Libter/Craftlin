package net.craftlin.plugin.api.value.base

import net.craftlin.plugin.util.BiHashMap
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

abstract class BiEnumValue<Api: Enum<*>, Impl>(private val apiClass: KClass<Api>) {

    inner class Delegate(private var origin: Impl) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return apiMap.byValue(toApi(origin)) ?: throw NotImplementedError()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            origin = toImpl(apiMap.byKey(value) ?: throw IllegalArgumentException())
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