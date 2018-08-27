package net.craftlin.api

import net.craftlin.api.command.CommandContext
import net.craftlin.api.event.BeforeJoinEvent
import net.craftlin.api.event.BreakEvent
import net.craftlin.api.event.ChatEvent
import net.craftlin.api.event.JoinEvent
import net.craftlin.api.event.LeaveEvent
import net.craftlin.api.event.MoveEvent
import net.craftlin.api.event.PlaceEvent
import net.craftlin.api.misc.Timer
import net.craftlin.api.misc.itF
import net.craftlin.api.misc.thisF
import net.craftlin.api.util.Listener

/** All variables passed to script.
 * @constructor This constructor is only for internal usage. */
abstract class Variables(listener: Listener) {

    /** Helper for common server-related actions like getting online players. */
    abstract val server: Server

    /** Registers a command */
    abstract val command: (definition: String, callback: thisF<CommandContext>) -> Unit

    /** Starts a task in the server main thread. */
    abstract val sync: (callback: itF) -> Unit

    /** Starts a task outside the server main thread. */
    abstract val async: (callback: itF) -> Unit

    /** Schedules a task in the server main thread. */
    abstract val delay: (time: Long, callback: itF) -> Unit

    /** Schedules a task outside the server main thread. */
    abstract val delayAsync: (time: Long, callback: itF) -> Unit

    /** Schedules a repeating task in the server main thread. */
    abstract val timer: (interval: Long, callback: thisF<Timer>) -> Unit

    /** Schedules a repeating task outside the server main thread. */
    abstract val timerAsync: (interval: Long, callback: thisF<Timer>) -> Unit

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

}