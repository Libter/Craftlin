package net.craftlin.plugin.api.entity

interface Player: Entity {
    val name: String
    var gamemode: String
    var isOp: Boolean

    fun message(message: String)
    fun kick(reason: String)
}