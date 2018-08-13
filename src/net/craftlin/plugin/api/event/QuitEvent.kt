package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player

interface QuitEvent: Event {

    val player: Player

    var quitMessage: String

}