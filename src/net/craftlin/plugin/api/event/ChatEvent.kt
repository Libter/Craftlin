package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.base.CancellableEvent

abstract class ChatEvent: CancellableEvent() {
    abstract val player: Player
    abstract var message: String
    abstract var format: String
}