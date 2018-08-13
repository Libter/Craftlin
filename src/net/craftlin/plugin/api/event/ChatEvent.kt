package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player

interface ChatEvent: Event {

    val player: Player

    var message: String

    var format: String


}