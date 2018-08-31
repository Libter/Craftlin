package net.craftlin.api.event

import net.craftlin.api.entity.Player
import net.craftlin.api.world.block.Block

/**
 * Base interface that is implemented by all events
 */
interface Event

/**
 * Represents an event that can be cancelled
 */
interface CancellableEvent: Event {
    var cancelled: Boolean
}

/**
 * Represents an event involved by a player
 */
interface PlayerEvent: Event {
    /** The player that involved this event */
    val player: Player
}

/**
 * Represents a block-related event
 */
interface BlockEvent: Event {
    /** Event-related block */
    val block: Block
}

/**
 * Represents an event involved by a player's interaction
 */
interface InteractEvent: PlayerEvent, CancellableEvent