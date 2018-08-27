package net.craftlin.bukkit.impl

import net.craftlin.api.Server
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.misc.itF
import net.craftlin.bukkit.BukkitCraftlin
import net.craftlin.bukkit.impl.entity.BukkitOfflinePlayer
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.misc.BukkitTask
import net.craftlin.bukkit.impl.world.BukkitWorld
import org.bukkit.Bukkit

object BukkitServer : Server {
    override val players: List<BukkitPlayer>
        get() = Bukkit.getServer().onlinePlayers.toList().map { BukkitPlayer(it) }
    override val worlds: List<BukkitWorld>
        get() = Bukkit.getServer().worlds.map { BukkitWorld(it) }

    override fun player(name: String): Player? = players.find { it.name == name }
    override fun offlinePlayer(name: String, callback: itF<OfflinePlayer?>) {
        BukkitTask { callback(BukkitOfflinePlayer(Bukkit.getOfflinePlayer(name))) }.runTaskAsynchronously(BukkitCraftlin.instance)
    }
}