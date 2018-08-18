package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.world.Block
import net.craftlin.plugin.api.world.Location

interface BeforeJoinEvent: Event {
    val name: String
    var result: String
    var message: String

    fun disallow(message: String)
}

interface JoinEvent: PlayerEvent {
    val first: Boolean
    var message: String
}

interface QuitEvent: PlayerEvent {
    var message: String
}

interface MoveEvent: PlayerEvent, CancellableEvent {
    val from: Location
    val to: Location
}

interface ChatEvent: PlayerEvent, CancellableEvent {
    var message: String
    var format: String
}

interface BreakEvent: PlayerEvent, BlockEvent, CancellableEvent {
    var dropItems: Boolean
}

interface PlaceEvent: PlayerEvent, BlockEvent, CancellableEvent {
    val placed get() = block
    val previous: Block
}