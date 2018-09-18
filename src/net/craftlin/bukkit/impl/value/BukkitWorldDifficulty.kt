package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.world.WorldDifficulty
import org.bukkit.Difficulty

object BukkitWorldDifficulty: EnumValue<WorldDifficulty, Difficulty>(WorldDifficulty::class) {
    override fun Converter(api: WorldDifficulty) = when (api) {
        WorldDifficulty.PEACEFUL -> Difficulty.PEACEFUL
        WorldDifficulty.EASY -> Difficulty.EASY
        WorldDifficulty.NORMAL -> Difficulty.NORMAL
        WorldDifficulty.HARD -> Difficulty.HARD
    }
}