package net.craftlin.api.entity

import net.craftlin.api.entity.base.Entity

interface Player: OfflinePlayer, Sender, Entity {
    var gamemode: String

    fun kick(reason: String)
}