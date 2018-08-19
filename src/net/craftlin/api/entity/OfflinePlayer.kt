package net.craftlin.api.entity

import java.util.Date

interface OfflinePlayer {
    val uuid: String
    val online: Boolean
    val name: String
    var op: Boolean
    val banned: Boolean
    var whitelisted: Boolean

    fun ban(reason: String? = null, expires: Date? = null)
    fun unban()

    fun toPlayer(): Player?
}