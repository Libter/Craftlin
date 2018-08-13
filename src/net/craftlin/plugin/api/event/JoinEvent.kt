package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player

interface JoinEvent: Event {

    val player: Player

    var joinMessage: String

}