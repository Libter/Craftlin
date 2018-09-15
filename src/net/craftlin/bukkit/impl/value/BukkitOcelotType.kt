package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.entity.OcelotVariant
import org.bukkit.entity.Ocelot

object BukkitOcelotType: EnumValue<OcelotVariant, Ocelot.Type>(OcelotVariant::class) {
    override fun Converter(api: OcelotVariant) = when (api) {
        OcelotVariant.BLACK_CAT -> Ocelot.Type.BLACK_CAT
        OcelotVariant.RED_CAT -> Ocelot.Type.RED_CAT
        OcelotVariant.SIAMESE_CAT -> Ocelot.Type.SIAMESE_CAT
        OcelotVariant.WILD_OCELOT -> Ocelot.Type.WILD_OCELOT
    }
}