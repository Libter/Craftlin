package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.entity.Player

interface JoinEvent {

    val player: Player

    var message: String

}