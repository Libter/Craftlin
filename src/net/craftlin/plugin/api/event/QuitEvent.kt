package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player

interface QuitEvent {

    val player: Player

    var message: String

}