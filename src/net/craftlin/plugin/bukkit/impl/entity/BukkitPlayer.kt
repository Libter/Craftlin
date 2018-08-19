package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.world.Location
import net.craftlin.plugin.bukkit.impl.value.BukkitGameMode
import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.GameMode
import java.util.Date

class BukkitPlayer(private val origin: org.bukkit.entity.Player): BukkitEntity(origin), Player  {
    override var whitelisted: Boolean
        get() = origin.isWhitelisted
        set(value) { origin.isWhitelisted = value }

    override val online: Boolean get() = origin.isOnline

    override val banned: Boolean
        get() = origin.isBanned

    private var originGameMode: GameMode
        get() = origin.gameMode
        set(value) { origin.gameMode = value }

    override val name: String = origin.name

    override var gamemode by BukkitGameMode.Delegate(::originGameMode)

    override fun hasPermission(name: String, checkOp: Boolean) = (checkOp && op) || origin.hasPermission(name)

    override var op: Boolean
        get() = origin.isOp
        set(value) { origin.isOp = value }

    override fun message(message: String) = origin.sendMessage(message)

    override fun kick(reason: String) = origin.kickPlayer(reason)

    override fun teleport(location: Location) {
        origin.teleport(org.bukkit.Location(origin.world,
            location.x, location.y, location.z, location.yaw, location.pitch))
    }

    override fun ban(reason: String?, expires: Date?) {
        Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(name, reason, expires, null)
    }

    override fun unban() {
        Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(name)
    }
}