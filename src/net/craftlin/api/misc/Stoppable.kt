package net.craftlin.api.misc

abstract class Stoppable {

    companion object {
        private val registry = ArrayList<Stoppable>()

        fun reset() {
            registry.forEach { it.stop() }
            registry.clear()
        }
    }

    init {
        registry.add(this)
    }

    abstract fun stop()

}