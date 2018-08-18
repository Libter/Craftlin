package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.Server
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.plugin.bukkit.impl.world.BukkitWorld
import org.bukkit.Bukkit

object BukkitServer: Server {
    override val worlds = Bukkit.getServer().worlds.map { BukkitWorld(it) }
    override val players = Bukkit.getOnlinePlayers().map { BukkitPlayer(it) }
}