package net.craftlin.bukkit.impl.command

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.misc.ItBlock
import net.craftlin.bukkit.impl.BukkitServer
import net.craftlin.bukkit.impl.entity.BukkitConsole
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.entity.BukkitSender
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender

class BukkitCommandContext(sender: CommandSender, command: Command, raw: String): CommandContext(command, raw) {

    override val sender = when (sender) {
        is org.bukkit.entity.Player -> BukkitPlayer(sender)
        is ConsoleCommandSender -> BukkitConsole(sender)
        //TODO: command blocks, etc.
        else -> BukkitSender(sender)
    }

    override fun getPlayer(key: String) = BukkitServer.player(text(key))

    override fun offlinePlayer(key: String, callback: ItBlock<OfflinePlayer?>) = BukkitServer.offlinePlayer(text(key), callback)
}