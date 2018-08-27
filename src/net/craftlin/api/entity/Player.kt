package net.craftlin.api.entity

import net.craftlin.api.entity.base.LivingEntity

interface Player: OfflinePlayer, LivingEntity, Sender {
    var gamemode: String

    fun kick(reason: String)
}