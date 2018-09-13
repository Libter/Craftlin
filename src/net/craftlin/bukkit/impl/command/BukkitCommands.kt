package net.craftlin.bukkit.impl.command

import net.craftlin.api.command.Command
import net.craftlin.api.util.Commands
import org.bukkit.command.CommandSender
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.server.ServerCommandEvent

class BukkitCommands: Commands(), Listener {

    @EventHandler
    fun onPlayerCommand(event: PlayerCommandPreprocessEvent) {
        get(event.message)?.let {
            it.invoke(context(it, event.message, event.player))
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onServerCommand(event: ServerCommandEvent) {
        get(event.command)?.let {
            it.invoke(context(it, event.command, event.sender))
            event.isCancelled = true
        }
    }

    private fun context(command: Command, raw: String, sender: CommandSender) =
        BukkitCommandContext(sender, command, raw)

}