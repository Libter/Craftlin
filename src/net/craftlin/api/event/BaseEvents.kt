package net.craftlin.api.event

import net.craftlin.api.entity.Player
import net.craftlin.api.misc.Block

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

    /**
     * Executes [block] if sender is not [Player] or is [Player.permitted],
     * otherwise sends message about lack of permissions
     */
    fun require(permission: String, block: Block) {
        if (player.permitted(permission)) {
            block()
        } else {
            player.message("&4You need a permission to execute this action: $permission")
        }
    }
}

/**
 * Represents a block-related event
 */
interface BlockEvent: Event {
    /** Event-related block */
    val block: net.craftlin.api.world.block.Block
}

/**
 * Represents an event involved by a player's interaction
 */
interface InteractEvent: PlayerEvent, CancellableEvent