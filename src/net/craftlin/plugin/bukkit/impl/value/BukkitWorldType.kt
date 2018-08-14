package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.WorldType
import net.craftlin.plugin.api.value.base.EnumValue
import org.bukkit.World

object BukkitWorldType: EnumValue<WorldType, World.Environment>(WorldType::class) {
    override fun convert(api: WorldType): World.Environment {
        return when(api) {
            WorldType.NORMAL -> World.Environment.NORMAL
            WorldType.NETHER -> World.Environment.NETHER
            WorldType.END -> World.Environment.THE_END
        }
    }
}