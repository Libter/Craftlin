package net.craftlin.bukkit.impl

import net.craftlin.api.entity.Player
import net.craftlin.api.entity.base.Entity
import net.craftlin.api.event.*
import net.craftlin.api.world.Location
import net.craftlin.api.world.block.Block
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.entity.base.BukkitLivingEntity
import net.craftlin.bukkit.impl.value.BukkitLoginResult
import net.craftlin.bukkit.impl.world.BukkitBlock
import net.craftlin.bukkit.impl.world.BukkitLocation
import org.bukkit.event.Cancellable
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.*
import org.bukkit.event.player.PlayerEvent

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
        set(value) { origin.joinMessage = value }
}

class BukkitLeaveEvent(private val origin: PlayerQuitEvent): LeaveEvent {
    override val player = BukkitPlayer(origin.player)
    override var message: String
        get() = origin.quitMessage
        set(value) { origin.quitMessage = value }
}

class BukkitChatEvent(private val origin: AsyncPlayerChatEvent): ChatEvent, BukkitCancellableEvent(origin) {
    override val player = BukkitPlayer(origin.player)
    override var message: String
        get() = origin.message
        set(value) { origin.message = value }
    override var format: String
        get() = origin.format
        set(value) { origin.format = value }
}

class BukkitBeforeLoginEvent(private val origin: AsyncPlayerPreLoginEvent): BeforeJoinEvent {
    private var originResult: AsyncPlayerPreLoginEvent.Result
        get() = origin.loginResult
        set(value) { origin.loginResult = value }

    override val name: String = origin.name
    override var result: String by BukkitLoginResult.Delegate(::originResult)
    override var message: String
        get() = origin.kickMessage
        set(value) { origin.kickMessage = value }

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
        get() = BukkitLocation(origin.to)
    override val to: Location
        get() = BukkitLocation(origin.to)
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
    override val isRight: Boolean
        get() = origin.action == Action.RIGHT_CLICK_BLOCK
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitEntityClickEvent(private val origin: PlayerInteractEntityEvent) : EntityClickEvent, BukkitCancellableEvent(origin) {
    override val entity: Entity
        get() = TODO("converting bukkit entity to craftlin entity")
    override val player: Player
        get() = BukkitPlayer(origin.player)
}

class BukkitButtonPressEvent(private val origin: PlayerInteractEvent) : BukkitBlockClickEvent(origin), ButtonPressEvent {
    override val isRight: Boolean get() = true
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