package net.craftlin.api.event

import net.craftlin.api.entity.base.Entity
import net.craftlin.api.inventory.Item
import net.craftlin.api.value.LoginResult
import net.craftlin.api.world.Location
import net.craftlin.api.world.block.Block

/**
 * An event triggered before a player joins the server.
 */
interface BeforeJoinEvent: Event {
    /** Player's nickname */
    val name: String
    /**
     * Login result
     * @see LoginResult
     */
    var result: String
    /** Message that will be shown to a player when he gets kicked */
    var message: String

    /** Disallows player from logging in, with the given [message] */
    fun disallow(message: String)
}

/**
 * An event triggered after a player joins the server.
 */
interface JoinEvent: PlayerEvent {
    /** Whether it's a first join or no **/
    val first: Boolean
    var message: String
}

/**
 * An event triggered after a player leaves the server
 */
interface LeaveEvent: PlayerEvent {
    /** Quit message displayed on the chat */
    var message: String
}

/**
 * An event triggered after a player moves from [from] to [to].
 */
interface MoveEvent: PlayerEvent, CancellableEvent {
    /** Location that player's moving from */
    val from: Location
    /** New player's location */
    val to: Location
}

/**
 * An event triggered after a player sends a message on the chat.
 */
interface ChatEvent: PlayerEvent, CancellableEvent {
    /** Message sent by the player */
    var message: String
    /** The format used to display a message. First parameter (%s) is the player's display name, and second is the [message] */
    var format: String
}

/**
 * An event triggered after a player breaks a [block].
 */
interface BreakEvent: PlayerEvent, BlockEvent, CancellableEvent {
    /** List of items to drop */
    val drop: MutableList<Item>
}

/**
 * An event triggered after a player places a [block].
 */
interface PlaceEvent: PlayerEvent, BlockEvent, CancellableEvent {
    /** The placed block **/
    val placed get() = block
    /** The previous block **/
    val previous: Block
}

/**
 * An event triggered when a player clicks something.
 */
interface ClickEvent: InteractEvent {
    /** Whether it is a right click or not */
    val right: Boolean
    /** Whether it is a left click or not. Returns negation of [right]*/
    val left get() = !right
}

/**
 * An event triggered when a player clicks in air.
 */
interface AirClickEvent: ClickEvent

/**
 * An event triggered when a player clicks an [entity]
 */
interface EntityClickEvent: ClickEvent {
    /** The event-related entity */
    val entity: Entity
    override val right get() = true
}

/**
 * An event triggered when a player clicks a [block]
 */
interface BlockClickEvent: BlockEvent, ClickEvent

/**
 * An event triggered when a player presses a [button][block]
 */
interface ButtonPressEvent: BlockClickEvent {
    override val right get() = true
}

/**
 * An event triggered when a player pulls a [lever][block]
 */
interface LeverPullEvent: BlockClickEvent {
    override val right get() = true
}

/**
 * An event triggered when a player triggers a tripwire circuit
 */
interface TripwireEvent: InteractEvent

/**
 * An event triggered when a player tramples down the soil (farmland)
 */
interface SoilJumpEvent : BlockEvent, InteractEvent

/**
 * An event triggered when a player stands on a [pressure plate][block]
 */
interface PressurePlateEvent: BlockEvent, InteractEvent {
    /** The event-related plate. Same as [block], defined only for clarity. */
    val plate get() = block
}