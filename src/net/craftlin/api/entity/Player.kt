package net.craftlin.api.entity

import net.craftlin.api.entity.base.Entity

interface Player: OfflinePlayer, Entity {
    var gamemode: String

    fun message(message: String)
    fun kick(reason: String)

    fun hasPermission(name: String, checkOp: Boolean = true): Boolean

    override fun toPlayer(): Player = this
}