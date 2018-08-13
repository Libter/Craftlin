package net.craftlin.plugin.api.event.base

class Handler<T: Event> {
    private val listeners = ArrayList<(T) -> Unit>()

    fun add(listener: (T) -> Unit) {
        listeners.add(listener)
    }

    fun trigger(event: T) {
        listeners.forEach { it(event) }
    }
}