package net.craftlin.bukkit.impl.command

import net.craftlin.api.command.Command
import net.craftlin.api.util.Commands
import net.craftlin.bukkit.BukkitCraftlin
import net.craftlin.bukkit.impl.misc.BukkitTask
import org.bukkit.command.CommandSender
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.server.ServerCommandEvent

class BukkitCommands: Commands(), Listener {

    @EventHandler
    fun onPlayerCommand(event: AsyncPlayerChatEvent) {
        get(event.message)?.let {
            val context = context(it, event.message, event.player)
            BukkitTask {
                if (event.player.isOnline) it.invoke(context)
            }.runTask(BukkitCraftlin.instance)
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerSlashCommand(event: PlayerCommandPreprocessEvent) {
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