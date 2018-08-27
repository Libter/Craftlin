package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Sender
import org.bukkit.command.ConsoleCommandSender

class BukkitConsole(private val origin: ConsoleCommandSender): Sender {
    override fun message(message: String) {
        origin.sendMessage(message)
    }
}
