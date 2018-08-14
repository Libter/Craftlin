package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.EnumValue
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result

object PlayerPreLoginResult: EnumValue<Result>() {
    override val values = mapOf(
        "allowed" to Result.ALLOWED,
        "banned" to Result.KICK_BANNED,
        "full" to Result.KICK_FULL,
        "whitelist" to Result.KICK_WHITELIST,
        "other" to Result.KICK_OTHER
    )
}