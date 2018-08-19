package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.OfflinePlayer
import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.bukkit.impl.BukkitServer
import org.bukkit.BanList
import org.bukkit.Bukkit
import java.util.Date

class BukkitOfflinePlayer(private val origin: org.bukkit.OfflinePlayer) : OfflinePlayer {
    override var isWhitelisted: Boolean
        get() = origin.isWhitelisted
        set(value) { origin.isWhitelisted = value }

    override val uuid: String get() = origin.uniqueId.toString()

    override val isOnline: Boolean get() = origin.isOnline

    override val name: String get() = origin.name

    override var isOp: Boolean
        get() = origin.isOp
        set(value) { origin.isOp = value }

    override val banned: Boolean
        get() = origin.isBanned

    override fun ban(reason: String?, expires: Date?) {
        if (!banned) {
            Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(name, reason, expires, null)
        }
    }

    override fun unban() {
        Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(name)
    }

    override fun toPlayer(): Player? = BukkitServer.players.find { it.uuid == uuid }
}