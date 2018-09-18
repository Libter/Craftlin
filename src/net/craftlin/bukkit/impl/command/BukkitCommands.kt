package net.craftlin.bukkit.impl.command

import net.craftlin.api.util.Commands
import net.craftlin.bukkit.BukkitCraftlin
import net.craftlin.bukkit.impl.misc.BukkitTask
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
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
            if (check(command, sender)) return
        }

        if (sender is Player) {
            sender.chat(command)
        } else {
            Bukkit.getServer().dispatchCommand(sender, "say $command")
        }
    }

    @EventHandler
    fun onPlayerCommand(event: AsyncPlayerChatEvent) {
        check(event.message, event.player, event)
    }

    @EventHandler
    fun onPlayerSlashCommand(event: PlayerCommandPreprocessEvent) {
        check(event.message, event.player, event)
    }

    @EventHandler
    fun onServerCommand(event: ServerCommandEvent) {
        check(event.command, event.sender, event)
    }

    private fun check(command: String, sender: CommandSender, event: Event? = null): Boolean {
        get(command)?.let {
            if (event is Cancellable) event.isCancelled = true
            val async = event?.isAsynchronous ?: false
            if (async) {
                BukkitTask {
                    it.invoke(BukkitCommandContext(sender, it, command))
                }.runTask(BukkitCraftlin.instance)
            } else {
                it.invoke(BukkitCommandContext(sender, it, command))
            }
            return true
        }
        return false
    }

}