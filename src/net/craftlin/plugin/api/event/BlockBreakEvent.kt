package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.base.CancellableEvent
import net.craftlin.plugin.api.location.Block

abstract class BlockBreakEvent: CancellableEvent() {
    abstract val player: Player
    abstract val block: Block
    abstract var dropItems: Boolean
}