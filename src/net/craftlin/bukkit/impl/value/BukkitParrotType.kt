package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.ParrotType
import org.bukkit.entity.Parrot

object BukkitParrotType: EnumValue<ParrotType, Parrot.Variant>(ParrotType::class) {
    override fun convert(api: ParrotType) = when (api) {
        ParrotType.BLUE -> Parrot.Variant.BLUE
        ParrotType.CYAN -> Parrot.Variant.CYAN
        ParrotType.GRAY -> Parrot.Variant.GRAY
        ParrotType.GREEN -> Parrot.Variant.GREEN
        ParrotType.RED -> Parrot.Variant.RED
    }
}