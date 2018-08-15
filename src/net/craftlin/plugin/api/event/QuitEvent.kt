package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.base.Event

interface QuitEvent: Event {
    val player: Player
    var message: String
}