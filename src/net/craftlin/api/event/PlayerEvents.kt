package net.craftlin.api.event

import net.craftlin.api.entity.base.Entity
import net.craftlin.api.world.Location
import net.craftlin.api.world.block.Block

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

interface LeaveEvent: PlayerEvent {
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

interface ClickEvent: InteractEvent {
    val isRight: Boolean
    val isLeft get() = !isRight
}

interface EntityClickEvent: ClickEvent {
    val entity: Entity
    override val isRight get() = true
}

interface BlockClickEvent: BlockEvent, ClickEvent

interface ButtonPressEvent: BlockClickEvent {
    override val isRight get() = true
}

interface LeverPullEvent: BlockClickEvent {
    override val isRight get() = true
}

interface TripwireEvent: InteractEvent

interface SoilJumpEvent : BlockEvent, InteractEvent

interface PressurePlateEvent: BlockEvent, InteractEvent {
    val plate get() = block
}