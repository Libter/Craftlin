package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Console
import net.craftlin.api.util.chat
import org.bukkit.command.ConsoleCommandSender

class BukkitConsole(private val origin: ConsoleCommandSender): Console {
    override fun message(message: String) = origin.sendMessage(message.chat)
}
