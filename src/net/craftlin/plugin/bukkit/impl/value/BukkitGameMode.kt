package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.util.value.EnumValue
import net.craftlin.plugin.api.value.GameMode

object BukkitGameMode: EnumValue<GameMode, org.bukkit.GameMode>(GameMode::class) {
    override fun convert(api: GameMode): org.bukkit.GameMode {
        return when (api) {
            GameMode.CREATIVE -> org.bukkit.GameMode.CREATIVE
            GameMode.SURVIVAL -> org.bukkit.GameMode.SURVIVAL
            GameMode.ADVENTURE -> org.bukkit.GameMode.ADVENTURE
            GameMode.SPECTATOR -> org.bukkit.GameMode.SPECTATOR
        }
    }
}