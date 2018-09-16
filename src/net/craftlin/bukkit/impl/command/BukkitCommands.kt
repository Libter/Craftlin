package net.craftlin.bukkit.impl.command

import net.craftlin.api.misc.emptyF
import net.craftlin.api.util.Commands
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.server.ServerCommandEvent

class BukkitCommands: Commands(), Listener {

    fun send(sender: CommandSender, command: String) {
        if (command.startsWith("/")) {
            Bukkit.getServer().dispatchCommand(sender, command.substring(1))
            return
        } else {
            check(command, sender) { return }
        }

        if (sender is Player) {
            sender.chat(command)
        } else {
            Bukkit.getServer().dispatchCommand(sender, "say $command")
        }
    }

    @EventHandler
    fun onPlayerCommand(event: AsyncPlayerChatEvent) {
        check(event.message, event.player) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerSlashCommand(event: PlayerCommandPreprocessEvent) {
        check(event.message, event.player) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onServerCommand(event: ServerCommandEvent) {
        check(event.command, event.sender) {
            event.isCancelled = true
        }
    }

    private inline fun check(command: String, sender: CommandSender, block: emptyF) {
        get(command)?.let {
            block()
            it.invoke(BukkitCommandContext(sender, it, command))
        }
    }

}