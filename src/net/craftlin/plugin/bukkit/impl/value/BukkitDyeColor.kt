package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.util.value.EnumValue
import net.craftlin.plugin.api.value.DyeColor

object BukkitDyeColor: EnumValue<DyeColor, org.bukkit.DyeColor>(DyeColor::class) {
    override fun convert(api: DyeColor): org.bukkit.DyeColor {//TODO
        return when (api) {
            DyeColor.BLACK -> org.bukkit.DyeColor.BLACK
            DyeColor.BLUE -> org.bukkit.DyeColor.BLUE
            DyeColor.BROWN -> org.bukkit.DyeColor.BROWN
                DyeColor.CYAN -> org.bukkit.DyeColor.CYAN
                DyeColor.GRAY -> org.bukkit.DyeColor.GRAY
                DyeColor.GREEN -> org.bukkit.DyeColor.GREEN
                DyeColor.LIGHT_BLUE -> org.bukkit.DyeColor.LIGHT_BLUE
                DyeColor.LIGHT_GRAY -> org.bukkit.DyeColor.LIGHT_GRAY
                DyeColor.LIME -> org.bukkit.DyeColor.LIGHT_BLUE
                DyeColor.MAGENTA -> org.bukkit.DyeColor.MAGENTA
                DyeColor.ORANGE -> org.bukkit.DyeColor.ORANGE
                DyeColor.PINK -> org.bukkit.DyeColor.PINK
                DyeColor.PURPLE -> org.bukkit.DyeColor.PURPLE
                DyeColor.RED -> org.bukkit.DyeColor.RED
                DyeColor.WHITE -> org.bukkit.DyeColor.WHITE
                DyeColor.YELLOW -> org.bukkit.DyeColor.YELLOW
        }
    }
}