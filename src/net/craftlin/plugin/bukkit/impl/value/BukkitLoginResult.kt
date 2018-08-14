package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.EnumValue
import org.bukkit.event.player.AsyncPlayerPreLoginEvent

object BukkitLoginResult: EnumValue<AsyncPlayerPreLoginEvent.Result>() {
    override val values = mapOf(
        "allow" to AsyncPlayerPreLoginEvent.Result.ALLOWED,
        "disallow" to AsyncPlayerPreLoginEvent.Result.KICK_OTHER
    )
}