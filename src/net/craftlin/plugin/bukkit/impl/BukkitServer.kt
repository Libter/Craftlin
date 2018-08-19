package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.Server
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.plugin.bukkit.impl.world.BukkitWorld
import org.bukkit.Bukkit

object BukkitServer : Server {
    override val players: List<BukkitPlayer>
        get() = Bukkit.getServer().onlinePlayers.toList().map { BukkitPlayer(it) }
    override val worlds: List<BukkitWorld>
        get() = Bukkit.getServer().worlds.map { BukkitWorld(it) }
}