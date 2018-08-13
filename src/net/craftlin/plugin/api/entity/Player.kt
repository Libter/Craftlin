package net.craftlin.plugin.api.entity

import net.craftlin.plugin.api.value.Location

abstract class Player {
    abstract val name: String
    abstract var gamemode: String

    abstract fun message(message: String)
    abstract fun kick(reason: String)
    abstract fun teleport(location: Location)
}