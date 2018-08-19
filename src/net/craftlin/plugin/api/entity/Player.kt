package net.craftlin.plugin.api.entity

interface Player: OfflinePlayer, Entity {
    var gamemode: String

    fun message(message: String)
    fun kick(reason: String)

    fun hasPermission(name: String, checkOp: Boolean = true): Boolean

    override fun toPlayer(): Player = this
}