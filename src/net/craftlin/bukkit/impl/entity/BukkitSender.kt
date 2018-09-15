package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Sender
import net.craftlin.api.util.chat
import net.craftlin.bukkit.BukkitCraftlin
import org.bukkit.command.CommandSender

abstract class BukkitSender(private val origin: CommandSender): Sender {

    override fun message(message: String) {
        origin.sendMessage(message.chat)
    }

    override fun command(command: String) {
        BukkitCraftlin.commands.send(origin, command)
    }

}