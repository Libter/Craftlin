package net.craftlin.plugin.api.entity

interface Player: Entity {
    abstract val name: String
    abstract var gamemode: String
    abstract var isOp: Boolean

    abstract fun message(message: String)
    abstract fun kick(reason: String)
}