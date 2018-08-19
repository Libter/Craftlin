package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.event.BeforeJoinEvent
import net.craftlin.plugin.api.event.BreakEvent
import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.LeaveEvent
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.plugin.bukkit.impl.value.BukkitLoginResult
import net.craftlin.plugin.bukkit.impl.world.BukkitBlock
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class BukkitJoinEvent(private val origin: PlayerJoinEvent): JoinEvent {
    override val player = BukkitPlayer(origin.player)
    override val first = origin.player.lastPlayed == 0L
    override var message: String
        get() = origin.joinMessage
        set(value) { origin.joinMessage = value }
}

class BukkitLeaveEvent(private val origin: PlayerQuitEvent): LeaveEvent {
    override val player = BukkitPlayer(origin.player)
    override var message: String
        get() = origin.quitMessage
        set(value) { origin.quitMessage = value }
}

class BukkitChatEvent(private val origin: AsyncPlayerChatEvent): ChatEvent {
    override val player = BukkitPlayer(origin.player)
    override var message: String
        get() = origin.message
        set(value) { origin.message = value }
    override var format: String
        get() = origin.format
        set(value) { origin.format = value }
    override var cancelled: Boolean
        get() = origin.isCancelled
        set(value) { origin.isCancelled = value }
}

class BukkitBeforeLoginEvent(private val origin: AsyncPlayerPreLoginEvent): BeforeJoinEvent {
    private var originResult: AsyncPlayerPreLoginEvent.Result
        get() = origin.loginResult
        set(value) { origin.loginResult = value }

    override val name: String = origin.name
    override var result: String by BukkitLoginResult.Delegate(::originResult)
    override var message: String
        get() = origin.kickMessage
        set(value) { origin.kickMessage = value }

    override fun disallow(message: String) {
        origin.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message)
    }
}

class BukkitBreakEvent(private val origin: org.bukkit.event.block.BlockBreakEvent): BreakEvent {
    override val player = BukkitPlayer(origin.player)
    override val block = BukkitBlock(origin.block)
    override var dropItems: Boolean
        get() = origin.isDropItems
        set(value) { origin.isDropItems = value }
    override var cancelled: Boolean
        get() = origin.isCancelled
        set(value) { origin.isCancelled = value }
}