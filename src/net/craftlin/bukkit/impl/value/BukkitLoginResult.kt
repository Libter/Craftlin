package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.BiEnumValue
import net.craftlin.api.value.LoginResult
import org.bukkit.event.player.AsyncPlayerPreLoginEvent

object BukkitLoginResult: BiEnumValue<LoginResult, AsyncPlayerPreLoginEvent.Result>(LoginResult::class) {
    override fun toImpl(api: LoginResult) = when(api) {
            LoginResult.ALLOW -> AsyncPlayerPreLoginEvent.Result.ALLOWED
            LoginResult.DISALLOW -> AsyncPlayerPreLoginEvent.Result.KICK_OTHER
    }

    override fun toApi(impl: AsyncPlayerPreLoginEvent.Result) = when(impl) {
        AsyncPlayerPreLoginEvent.Result.ALLOWED -> LoginResult.ALLOW
        else -> LoginResult.DISALLOW
    }
}