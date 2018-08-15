package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.base.CancellableEvent
import net.craftlin.plugin.api.world.Block

interface BlockBreakEvent: CancellableEvent {
    val player: Player
    val block: Block
    var dropItems: Boolean
}