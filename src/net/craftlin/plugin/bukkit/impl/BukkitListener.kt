package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class BukkitListener: Listener(), org.bukkit.event.Listener {

    @EventHandler
    fun triggerJoin(event: PlayerJoinEvent) = joinHandler.trigger(BukkitJoinEvent(event))

    @EventHandler
    fun triggerQuit(event: PlayerQuitEvent) = quitHandler.trigger(BukkitQuitEvent(event))

    @EventHandler
    fun triggerChat(event: AsyncPlayerChatEvent) = chatHandler.trigger(BukkitChatEvent(event))

}