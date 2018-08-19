package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.world.Block

interface Event

interface CancellableEvent: Event {
    var cancelled: Boolean
}

interface PlayerEvent: Event {
    val player: Player
}

interface BlockEvent: Event {
    val block: Block
}