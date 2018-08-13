package net.craftlin.plugin.api

abstract class Listener {

    protected val joinListeners = ArrayList<(Player) -> Unit>()
    fun onJoin(listener: (Player) -> Unit) {
        joinListeners.add(listener)
    }

}