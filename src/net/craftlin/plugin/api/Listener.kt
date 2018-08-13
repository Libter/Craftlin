package net.craftlin.plugin.api

import net.craftlin.plugin.api.entity.Player

abstract class Listener {

    protected val joinListeners = ArrayList<(Player) -> Unit>()
    fun onJoin(listener: (Player) -> Unit) {
        joinListeners.add(listener)
    }

}