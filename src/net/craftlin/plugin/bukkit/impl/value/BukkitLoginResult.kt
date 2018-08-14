package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.LoginResult
import net.craftlin.plugin.api.value.base.BiEnumValue
import org.bukkit.event.player.AsyncPlayerPreLoginEvent

object BukkitLoginResult: BiEnumValue<LoginResult, AsyncPlayerPreLoginEvent.Result>(LoginResult::class) {
    override fun toImpl(api: LoginResult): AsyncPlayerPreLoginEvent.Result {
        return when(api) {
            LoginResult.ALLOW -> AsyncPlayerPreLoginEvent.Result.ALLOWED
            LoginResult.DISALLOW -> AsyncPlayerPreLoginEvent.Result.KICK_OTHER
        }
    }

    override fun toApi(impl: AsyncPlayerPreLoginEvent.Result): LoginResult {
        return when(impl) {
            AsyncPlayerPreLoginEvent.Result.ALLOWED -> LoginResult.ALLOW
            else -> LoginResult.DISALLOW
        }
    }
}