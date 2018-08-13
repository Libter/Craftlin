package net.craftlin.plugin.api.entity

import net.craftlin.plugin.api.Location

interface Player {

    val name: String

    var isFlyEnabled: Boolean

    var gamemode: Gamemode

    fun message(message: String)

    fun kick(reason: String)

    fun teleport(location: Location)

    fun ban(reason: String)
}