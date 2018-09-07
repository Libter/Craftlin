package net.craftlin.bukkit.impl.command

import net.craftlin.api.util.Commands
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.server.ServerCommandEvent

class BukkitCommands: Commands<BukkitCommandContext>(), Listener {

    @EventHandler
    fun onPlayerCommand(event: PlayerCommandPreprocessEvent) {
        get(event.message)?.let {
            it.invoke(BukkitCommandContext(it, event.player, event.message))
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onServerCommand(event: ServerCommandEvent) {
        get(event.command)?.let {
            it.invoke(BukkitCommandContext(it, event.sender, event.command))
            event.isCancelled = true
        }
    }

}