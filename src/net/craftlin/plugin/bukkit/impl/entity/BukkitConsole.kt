package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.Sender
import org.bukkit.command.ConsoleCommandSender

class BukkitConsole(val origin: ConsoleCommandSender): Sender {
    override fun message(text: String) {
        origin.sendMessage(text)
    }
}
