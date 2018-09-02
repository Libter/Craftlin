package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.entity.ParrotVariant
import org.bukkit.entity.Parrot

object BukkitParrotType: EnumValue<ParrotVariant, Parrot.Variant>(ParrotVariant::class) {
    override fun convert(api: ParrotVariant) = when (api) {
        ParrotVariant.BLUE -> Parrot.Variant.BLUE
        ParrotVariant.CYAN -> Parrot.Variant.CYAN
        ParrotVariant.GRAY -> Parrot.Variant.GRAY
        ParrotVariant.GREEN -> Parrot.Variant.GREEN
        ParrotVariant.RED -> Parrot.Variant.RED
    }
}