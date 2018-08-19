package net.craftlin.api.util.value

import net.craftlin.api.util.BiHashMap
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.isAccessible

abstract class EnumValue<Api: Enum<*>, Impl>(private val apiClass: KClass<Api>) {

    //For simplicity scripts will use strings instead enums
    //However we still wan't to use enums in our plugin
    inner class Delegate(private val origin: KMutableProperty<Impl>) {
        init {
            origin.getter.isAccessible = true
            origin.setter.isAccessible = true
        }

        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            val api = implMap.byValue(origin.getter.call()) ?: throw NotImplementedError()
            return apiMap.byValue(api) ?: throw NotImplementedError()
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            val api = apiMap.byKey(value) ?: throw IllegalArgumentException()
            origin.setter.call(implMap.byKey(api) ?: throw NotImplementedError())
        }
    }

    fun Converter(origin: Impl): String {
        val api = implMap.byValue(origin) ?: throw NotImplementedError()
        return apiMap.byValue(api) ?: throw NotImplementedError()
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