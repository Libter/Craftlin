package net.craftlin.bukkit.impl.command

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.bukkit.impl.BukkitServer
import net.craftlin.bukkit.impl.entity.BukkitConsole
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender

class BukkitCommandContext(command: Command, sender: CommandSender, args: Array<String>): CommandContext(command, args) {

    override val sender = when {
        sender is org.bukkit.entity.Player -> BukkitPlayer(sender)
        sender is ConsoleCommandSender -> BukkitConsole(sender)
        else -> throw NotImplementedError()
    }

    override fun player(key: String): Player = BukkitServer.player(forceGet(key)) ?: throw exception

    override fun offlinePlayer(key: String): OfflinePlayer {
        //TODO: the best solution is to get offline player asynchronously and then return to next instruction - is it possible?
        throw NotImplementedError()
    }

}