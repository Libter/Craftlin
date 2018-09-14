package net.craftlin.bukkit.impl

import net.craftlin.api.entity.Player
import net.craftlin.api.entity.base.Entity
import net.craftlin.api.event.AirClickEvent
import net.craftlin.api.event.BeforeJoinEvent
import net.craftlin.api.event.BlockClickEvent
import net.craftlin.api.event.BreakEvent
import net.craftlin.api.event.ButtonPressEvent
import net.craftlin.api.event.CancellableEvent
import net.craftlin.api.event.ChatEvent
import net.craftlin.api.event.EntityClickEvent
import net.craftlin.api.event.JoinEvent
import net.craftlin.api.event.LeaveEvent
import net.craftlin.api.event.LeverPullEvent
import net.craftlin.api.event.MoveEvent
import net.craftlin.api.event.PlaceEvent
import net.craftlin.api.event.PressurePlateEvent
import net.craftlin.api.event.SoilJumpEvent
import net.craftlin.api.event.TripwireEvent
import net.craftlin.api.util.chat
import net.craftlin.api.world.Location
import net.craftlin.api.world.block.Block
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.entity.base.BukkitEntity
import net.craftlin.bukkit.impl.value.BukkitLoginResult
import net.craftlin.bukkit.impl.world.BukkitBlock
import net.craftlin.bukkit.impl.world.BukkitLocation
import org.bukkit.event.Cancellable
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerQuitEvent

abstract class BukkitCancellableEvent(private val origin: Cancellable) : CancellableEvent {
    override var cancelled: Boolean
        get() = origin.isCancelled
        set(value) {origin.isCancelled = true}
}

class BukkitJoinEvent(private val origin: PlayerJoinEvent): JoinEvent {
    override val player = BukkitPlayer(origin.player)
    override val first = origin.player.lastPlayed == 0L
    override var message: String
        get() = origin.joinMessage
        set(value) { origin.joinMessage = value.chat }
}

class BukkitLeaveEvent(private val origin: PlayerQuitEvent): LeaveEvent {
    override val player = BukkitPlayer(origin.player)
    override var message: String
        get() = origin.quitMessage
        set(value) { origin.quitMessage = value.chat }
}

class BukkitChatEvent(private val origin: AsyncPlayerChatEvent): ChatEvent, BukkitCancellableEvent(origin) {
    override val player = BukkitPlayer(origin.player)
    override var message: String
        get() = origin.message
        set(value) { origin.message = value.chat }
    override var format: String
        get() = origin.format
        set(value) { origin.format = value.chat }
}

class BukkitBeforeLoginEvent(private val origin: AsyncPlayerPreLoginEvent): BeforeJoinEvent {
    private var originResult: AsyncPlayerPreLoginEvent.Result
        get() = origin.loginResult
        set(value) { origin.loginResult = value }

    override val name: String = origin.name
    override var result: String by BukkitLoginResult.Delegate(::originResult)
    override var message: String
        get() = origin.kickMessage
        set(value) { origin.kickMessage = value.chat }

    override fun disallow(message: String) {
        origin.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message)
    }
}

class BukkitBreakEvent(private val origin: org.bukkit.event.block.BlockBreakEvent): BreakEvent, BukkitCancellableEvent(origin) {
    override val player = BukkitPlayer(origin.player)
    override val block = BukkitBlock(origin.block)
    override var dropItems: Boolean
        get() = origin.isDropItems
        set(value) { origin.isDropItems = value }
}

class BukkitMoveEvent(private val origin: PlayerMoveEvent) : MoveEvent, BukkitCancellableEvent(origin) {
    override val from: Location
        get() = BukkitLocation.from(origin.from)
    override val to: Location
        get() = BukkitLocation.from(origin.to)
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitPlaceEvent(private val origin: BlockPlaceEvent) : PlaceEvent, BukkitCancellableEvent(origin) {
    override val previous: Block
        get() = BukkitBlock(origin.blockAgainst)
    override val player: Player
        get() = BukkitPlayer(origin.player)
    override val block: Block
        get() = BukkitBlock(origin.blockPlaced)
}

open class BukkitBlockClickEvent(private val origin: PlayerInteractEvent) : BlockClickEvent, BukkitCancellableEvent(origin) {
    override val block: Block
        get() = BukkitBlock(origin.clickedBlock!!)
    override val right: Boolean
        get() = origin.action == Action.RIGHT_CLICK_BLOCK
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitAirClickEvent(private val origin: PlayerInteractEvent) : AirClickEvent, BukkitCancellableEvent(origin) {
    override val right: Boolean
        get() = origin.action == Action.RIGHT_CLICK_AIR
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitEntityClickEvent(private val origin: PlayerInteractEntityEvent) : EntityClickEvent, BukkitCancellableEvent(origin) {
    override val entity: Entity
        get() = BukkitEntity.create(origin.rightClicked)
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitButtonPressEvent(private val origin: PlayerInteractEvent) : BukkitBlockClickEvent(origin), ButtonPressEvent {
    override val right: Boolean get() = true
}

class BukkitLeverPullEvent(private val origin: PlayerInteractEvent) : LeverPullEvent, BukkitCancellableEvent(origin) {
    override val player: Player
        get() = BukkitPlayer(origin.player)
    override val block: Block
        get() = BukkitBlock(origin.clickedBlock!!)
}

class BukkitTripwireEvent(private val origin: PlayerInteractEvent) : TripwireEvent, BukkitCancellableEvent(origin) {
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitPressurePlateEvent(private val origin: PlayerInteractEvent) : PressurePlateEvent, BukkitCancellableEvent(origin) {
    override val player: Player
        get() = BukkitPlayer(origin.player)
    override val block: Block
        get() = BukkitBlock(origin.clickedBlock)
}

class BukkitSoilJumpEvent(private val origin: PlayerInteractEvent) : SoilJumpEvent, BukkitCancellableEvent(origin) {
    override val player: Player
        get() = BukkitPlayer(origin.player)
    override val block: Block
        get() = BukkitBlock(origin.clickedBlock)
}