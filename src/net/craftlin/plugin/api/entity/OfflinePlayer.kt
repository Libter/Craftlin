package net.craftlin.plugin.api.entity

import java.util.Date

interface OfflinePlayer {
    val uuid: String
    val isOnline: Boolean
    val name: String
    var isOp: Boolean
    val banned: Boolean
    var isWhitelisted: Boolean

    fun ban(reason: String? = null, expires: Date? = null)
    fun unban()

    fun toPlayer(): Player?
}