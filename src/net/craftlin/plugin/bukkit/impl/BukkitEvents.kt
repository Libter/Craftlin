package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.event.BlockBreakEvent
import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.PreLoginEvent
import net.craftlin.plugin.api.event.QuitEvent
import net.craftlin.plugin.api.value.EnumDelegate
import net.craftlin.plugin.api.value.SimpleDelegate
import net.craftlin.plugin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.plugin.bukkit.impl.location.BukkitBlock
import net.craftlin.plugin.bukkit.impl.value.BukkitLoginResult
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class BukkitJoinEvent(origin: PlayerJoinEvent): JoinEvent() {
    override val player = BukkitPlayer(origin.player)
    override var message: String by SimpleDelegate(origin.joinMessage)
}

class BukkitQuitEvent(origin: PlayerQuitEvent): QuitEvent() {
    override val player = BukkitPlayer(origin.player)
    override var message: String by SimpleDelegate(origin.quitMessage)
}

class BukkitChatEvent(origin: AsyncPlayerChatEvent): ChatEvent() {
    override val player = BukkitPlayer(origin.player)
    override var message: String by SimpleDelegate(origin.message)
    override var format: String by SimpleDelegate(origin.format)
    override var cancelled by SimpleDelegate(origin.isCancelled)
}

class BukkitPreLoginEvent(private val origin: AsyncPlayerPreLoginEvent): PreLoginEvent() {
    override val name: String = origin.name
    override var result: String by EnumDelegate(BukkitLoginResult, origin.loginResult)
    override var message: String by SimpleDelegate(origin.kickMessage)

    override fun disallow(message: String) {
        origin.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message)
    }
}

class BukkitBlockBreakEvent(origin: org.bukkit.event.block.BlockBreakEvent): BlockBreakEvent() {
    override val player = BukkitPlayer(origin.player)
    override val block = BukkitBlock(origin.block)
    override var dropItems = origin.isDropItems
    override var cancelled by SimpleDelegate(origin.isCancelled)
}