package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.thisF
import kotlin.reflect.KClass

abstract class Listener {

    class Handler<T: Event> {
        private val listeners = ArrayList<thisF<T>>()

        fun add(listener: thisF<T>) {
            listeners.add(listener)
        }

        fun trigger(event: T) {
            listeners.forEach { it(event) }
        }
    }

    val handlers = HashMap<KClass<Event>, Handler<out Event>>()

    protected inline fun <reified T: Event> trigger(event: T) {
        val handler = handlers[T::class as KClass<Event>] as? Handler<T> ?: return
        handler.trigger(event)
    }

    inline fun <reified T: Event> add(): (thisF<T>) -> Unit {
        val clazz = T::class as KClass<Event>
        val handler = handlers[clazz] ?: Handler<T>()
        handlers[clazz] = handler as Handler<T>
        return handler::add
    }

}