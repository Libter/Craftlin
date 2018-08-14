package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.event.base.Event

abstract class PreLoginEvent: Event() {
    abstract val name: String
    abstract var result: String
    abstract var message: String

    abstract fun disallow(message: String)
}