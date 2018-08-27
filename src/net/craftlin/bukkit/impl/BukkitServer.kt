package net.craftlin.bukkit.impl

import net.craftlin.api.Server
import net.craftlin.api.commands.Command
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.world.BukkitWorld
import org.bukkit.Bukkit

object BukkitServer : Server {
    override val craftlinCommands: List<Command>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun registerCommand(command: Command, pattern: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val players: List<BukkitPlayer>
        get() = Bukkit.getServer().onlinePlayers.toList().map { BukkitPlayer(it) }
    override val worlds: List<BukkitWorld>
        get() = Bukkit.getServer().worlds.map { BukkitWorld(it) }
}