package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.world.WorldType
import org.bukkit.World

object BukkitWorldType: EnumValue<WorldType, World.Environment>(WorldType::class) {
    override fun Converter(api: WorldType) = when(api) {
        WorldType.NORMAL -> World.Environment.NORMAL
        WorldType.NETHER -> World.Environment.NETHER
        WorldType.END -> World.Environment.THE_END
    }
}