package net.craftlin.api

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.event.*
import net.craftlin.api.misc.Block
import net.craftlin.api.misc.ThisBlock
import net.craftlin.api.misc.ThisResultBlock
import net.craftlin.api.misc.Timer
import net.craftlin.api.util.Commands
import net.craftlin.api.util.Listener

/** All variables passed to script. */
abstract class Variables internal constructor(listener: Listener, private val commands: Commands) {

    /** Helper for common server-related actions like getting online players. */
    abstract val server: Server

    /** Starts a task in the server main thread. */
    abstract val sync: (callback: Block) -> Unit

    /** Starts a task outside the server main thread. */
    abstract val async: (callback: Block) -> Unit

    /** Schedules a task in the server main thread. */
    abstract val delay: (time: Long, callback: Block) -> Unit

    /** Schedules a task outside the server main thread. */
    abstract val delayAsync: (time: Long, callback: Block) -> Unit

    /** Schedules a repeating task in the server main thread. */
    abstract val timer: (interval: Long, callback: ThisBlock<Timer>) -> Unit

    /** Schedules a repeating task outside the server main thread. */
    abstract val timerAsync: (interval: Long, callback: ThisBlock<Timer>) -> Unit

    /** Registers a command */
    val command = fun(definition: String, callback: ThisBlock<CommandContext>) {
        commands.add(Command(definition, callback))
    }

    /** Registers an alias for a command */
    val alias = fun(definition: String, callback: ThisResultBlock<CommandContext, String>) {
        commands.add(Command.alias(definition, callback))
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