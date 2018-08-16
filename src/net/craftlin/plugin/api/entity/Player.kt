package net.craftlin.plugin.api.entity

import net.craftlin.plugin.api.entity.base.Entity

interface Player: Entity, Sender {
    val name: String
    var gamemode: String
    var isOp: Boolean

    fun kick(reason: String)
}