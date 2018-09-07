package net.craftlin.bukkit.impl.command

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.misc.itF
import net.craftlin.bukkit.impl.BukkitServer
import net.craftlin.bukkit.impl.entity.BukkitConsole
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender

class BukkitCommandContext(command: Command<*>, sender: CommandSender, raw: String): CommandContext(command, raw) {

    override val sender = when (sender) {
        is org.bukkit.entity.Player -> BukkitPlayer(sender)
        is ConsoleCommandSender -> BukkitConsole(sender)
        else -> throw NotImplementedError()
    }

    override fun player(key: String): Player = BukkitServer.player(forceGet(key)) ?: throw exception

    override fun offlinePlayer(key: String, callback: itF<OfflinePlayer?>) = BukkitServer.offlinePlayer(text(key), callback)
}