package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.event.BlockBreakEvent
import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.PreLoginEvent
import net.craftlin.plugin.api.event.QuitEvent
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.plugin.bukkit.impl.location.BukkitBlock
import net.craftlin.plugin.bukkit.impl.value.BukkitLoginResult
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
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

class BukkitPreLoginEvent(val origin: AsyncPlayerPreLoginEvent): PreLoginEvent() {
    override val name = origin.name
    override var result: String
        get() = BukkitLoginResult.toString(origin.loginResult)
        set(value) { origin.loginResult = BukkitLoginResult.fromString(value) }
    override var message: String
        get() = origin.kickMessage
        set(value) { origin.kickMessage = value }

    override fun disallow(message: String) {
        origin.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message)
    }
}

class BukkitBlockBreakEvent(val origin: org.bukkit.event.block.BlockBreakEvent): BlockBreakEvent() {
    override val player = BukkitPlayer(origin.player)
    override val block = BukkitBlock(origin.block)
    override var isDropItems = origin.isDropItems
    override var isCancelled: Boolean
        get() = origin.isCancelled
        set(value) { origin.isCancelled = value }
}