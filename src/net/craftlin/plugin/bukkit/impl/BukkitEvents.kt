package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.QuitEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class BukkitJoinEvent(origin: PlayerJoinEvent): JoinEvent() {
    override val player = BukkitPlayer(origin.player)
    override var message = origin.joinMessage
}

class BukkitQuitEvent(origin: PlayerQuitEvent): QuitEvent() {
    override val player = BukkitPlayer(origin.player)
    override var message = origin.quitMessage
}

class BukkitChatEvent(origin: AsyncPlayerChatEvent): ChatEvent() {
    override val player = BukkitPlayer(origin.player)
    override var message = origin.message
    override var format = origin.format
    override var isCancelled = origin.isCancelled
}