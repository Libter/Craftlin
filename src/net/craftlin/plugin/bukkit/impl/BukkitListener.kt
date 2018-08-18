package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.event.BeforeJoinEvent
import net.craftlin.plugin.api.event.BreakEvent
import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.api.event.QuitEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class BukkitListener: Listener(), org.bukkit.event.Listener {

    @EventHandler
    fun triggerJoin(event: PlayerJoinEvent) = trigger<JoinEvent>(BukkitJoinEvent(event))

    @EventHandler
    fun triggerQuit(event: PlayerQuitEvent) = trigger<QuitEvent>(BukkitQuitEvent(event))

    @EventHandler
    fun triggerChat(event: AsyncPlayerChatEvent) = trigger<ChatEvent>(BukkitChatEvent(event))

    @EventHandler
    fun triggerBeforeLogin(event: AsyncPlayerPreLoginEvent) = trigger<BeforeJoinEvent>(BukkitBeforeLoginEvent(event))

    @EventHandler
    fun triggerBreak(event: BlockBreakEvent) = trigger<BreakEvent>(BukkitBreakEvent(event))

}