package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Entity
import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.base.CancellableEvent
import net.craftlin.plugin.api.world.Block

abstract class PlayerInteractEvent: CancellableEvent {
    abstract val player: Player
}

abstract class ClickEvent: PlayerInteractEvent() {
    abstract val isRight: Boolean
    val isLeft get() = !isRight
}

abstract class EntityClickEvent: ClickEvent() {
    abstract val entity: Entity
}

abstract class BlockClickEvent: ClickEvent() {
    abstract val block: Block
}

abstract class ButtonClickEvent: BlockClickEvent() {
    override val isRight = true
}

abstract class LeverPullEvent: BlockClickEvent() {
    override val isRight = true
}

abstract class TripwireTrigger: PlayerInteractEvent()

abstract class SoilJumpEvent : PlayerInteractEvent() {
    abstract val block: Block
}

abstract class PlateTriggerEvent: PlayerInteractEvent() {
    abstract val plate: Block
}