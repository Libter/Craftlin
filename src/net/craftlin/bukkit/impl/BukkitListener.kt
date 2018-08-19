package net.craftlin.bukkit.impl

import net.craftlin.api.event.BeforeJoinEvent
import net.craftlin.api.event.BreakEvent
import net.craftlin.api.event.ChatEvent
import net.craftlin.api.event.JoinEvent
import net.craftlin.api.event.LeaveEvent
import net.craftlin.api.util.Listener
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
    fun triggerQuit(event: PlayerQuitEvent) = trigger<LeaveEvent>(BukkitLeaveEvent(event))

    @EventHandler
    fun triggerChat(event: AsyncPlayerChatEvent) = trigger<ChatEvent>(BukkitChatEvent(event))

    @EventHandler
    fun triggerBeforeLogin(event: AsyncPlayerPreLoginEvent) = trigger<BeforeJoinEvent>(BukkitBeforeLoginEvent(event))

    @EventHandler
    fun triggerBreak(event: BlockBreakEvent) = trigger<BreakEvent>(BukkitBreakEvent(event))

}