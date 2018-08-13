package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.base.Event

abstract class JoinEvent: Event() {
    abstract val player: Player
    abstract var message: String
}