package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.EnumValue
import org.bukkit.GameMode

object BukkitGameMode: EnumValue<org.bukkit.GameMode>() {
    override val values = mapOf(
        "survival" to GameMode.SURVIVAL,
        "creative" to GameMode.CREATIVE,
        "spectator" to GameMode.SPECTATOR,
        "adventure" to GameMode.ADVENTURE
    )
}