package net.craftlin.plugin.api.value.base

import net.craftlin.plugin.util.BiHashMap
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

abstract class EnumValue<Api: Enum<*>, Impl>(private val apiClass: KClass<Api>) {

    //For simplicity scripts will use strings instead enums
    //However we still wan't to use enums in our plugin
    inner class Delegate(private var origin: Impl) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            val api = implMap.byValue(origin) ?: throw NotImplementedError()
            return apiMap.byValue(api) ?: throw NotImplementedError()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            val api = apiMap.byKey(value) ?: throw IllegalArgumentException()
            origin = implMap.byKey(api) ?: throw NotImplementedError()
        }
    }

    protected abstract fun convert(api: Api): Impl

    private val apiMap by lazy {
        val map = BiHashMap<String, Api>()
        (apiClass.java.enumConstants as Array<out Api>).forEach {
            map[it.name.toLowerCase().replace('_', ' ')] = it
        }
        map
    }

    private val implMap by lazy {
        val map = BiHashMap<Api, Impl>()
        (apiClass.java.enumConstants as Array<out Api>).forEach {
            map[it] = convert(it)
        }
        map
    }
}