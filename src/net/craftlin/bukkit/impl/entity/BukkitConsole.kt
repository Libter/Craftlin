package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Sender
import org.bukkit.command.ConsoleCommandSender

class BukkitConsole(val origin: ConsoleCommandSender): Sender {
    override fun message(text: String) {
        origin.sendMessage(text)
    }
}
