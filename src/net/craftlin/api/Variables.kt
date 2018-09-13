package net.craftlin.api

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.event.AirClickEvent
import net.craftlin.api.event.BeforeJoinEvent
import net.craftlin.api.event.BlockClickEvent
import net.craftlin.api.event.BreakEvent
import net.craftlin.api.event.ButtonPressEvent
import net.craftlin.api.event.ChatEvent
import net.craftlin.api.event.ClickEvent
import net.craftlin.api.event.EntityClickEvent
import net.craftlin.api.event.JoinEvent
import net.craftlin.api.event.LeaveEvent
import net.craftlin.api.event.LeverPullEvent
import net.craftlin.api.event.MoveEvent
import net.craftlin.api.event.PlaceEvent
import net.craftlin.api.event.PressurePlateEvent
import net.craftlin.api.event.SoilJumpEvent
import net.craftlin.api.event.TripwireEvent
import net.craftlin.api.misc.Timer
import net.craftlin.api.misc.emptyF
import net.craftlin.api.misc.thisF
import net.craftlin.api.util.Commands
import net.craftlin.api.util.Listener

/** All variables passed to script.
 * @constructor This constructor is only for internal usage. */
abstract class Variables(listener: Listener, private val commands: Commands) {

    /** Helper for common server-related actions like getting online players. */
    abstract val server: Server

    /** Starts a task in the server main thread. */
    abstract val sync: (callback: emptyF) -> Unit

    /** Starts a task outside the server main thread. */
    abstract val async: (callback: emptyF) -> Unit

    /** Schedules a task in the server main thread. */
    abstract val delay: (time: Long, callback: emptyF) -> Unit

    /** Schedules a task outside the server main thread. */
    abstract val delayAsync: (time: Long, callback: emptyF) -> Unit

    /** Schedules a repeating task in the server main thread. */
    abstract val timer: (interval: Long, callback: thisF<Timer>) -> Unit

    /** Schedules a repeating task outside the server main thread. */
    abstract val timerAsync: (interval: Long, callback: thisF<Timer>) -> Unit

    /** Registers a command */
    val command = fun(definition: String, callback: thisF<CommandContext>) {
        commands.add(Command(definition, callback))
    }

    /** Registers an **asynchronous** listener triggered before a player joins server. */
    val beforeJoin = listener.add<BeforeJoinEvent>()

    /** Registers a listener triggered after a player joins server. */
    val onJoin = listener.add<JoinEvent>()

    /** Registers a listener triggered after a player leaves server. */
    val onLeave = listener.add<LeaveEvent>()

    /** Registers a listener triggered while a player is changing their location or rotation. */
    val onMove = listener.add<MoveEvent>()

    /** Registers an **asynchronous** listener triggered while a player is sending chat message. */
    val onChat = listener.add<ChatEvent>()

    /** Registers a listener triggered while a player is breaking block. */
    val onBreak = listener.add<BreakEvent>()

    /** Registers a listener triggered while a player is placing block. */
    val onPlace = listener.add<PlaceEvent>()

    /** Registers a listener triggered when a player clicks something. */
    val onClick = listener.add<ClickEvent>()

    /** Registers a listener triggered when a player clicks air. */
    val onAirClick = listener.add<AirClickEvent>()

    /** Registers a listener triggered when a player clicks a block. */
    val onBlockClick = listener.add<BlockClickEvent>()

    /** Registers a listener trigerred when a player presses a button. */
    val onButtonPress = listener.add<ButtonPressEvent>()

    /** Registers a listener triggered when a player pulls a lever. */
    val onLeverPull = listener.add<LeverPullEvent>()

    /** Registers a listener triggered when a player jumps on a soil (farmland) */
    val onSoilJump = listener.add<SoilJumpEvent>()

    /** Registers a listener triggered when a player right-clicks an entity. */
    val onEntityClick = listener.add<EntityClickEvent>()

    /** Registers a listener triggered when a player stands on a pressure plate. */
    val onPressurePlate = listener.add<PressurePlateEvent>()

    /** Registers a listener triggered when a player passes through a tripwire */
    val onTripwire = listener.add<TripwireEvent>()
}