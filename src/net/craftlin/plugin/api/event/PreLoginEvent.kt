package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.event.base.Event

interface PreLoginEvent: Event {
    val name: String
    var result: String
    var message: String

    fun disallow(message: String)
}