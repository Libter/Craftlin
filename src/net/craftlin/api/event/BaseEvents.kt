package net.craftlin.api.event

import net.craftlin.api.entity.Player
import net.craftlin.api.world.block.Block

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

interface InteractEvent: PlayerEvent, CancellableEvent