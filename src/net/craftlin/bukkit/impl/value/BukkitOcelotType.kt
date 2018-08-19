package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.OcelotType
import org.bukkit.entity.Ocelot

object BukkitOcelotType: EnumValue<OcelotType, Ocelot.Type>(OcelotType::class) {
    override fun convert(api: OcelotType): Ocelot.Type {
        return when (api) {
            OcelotType.BLACK_CAT -> Ocelot.Type.BLACK_CAT
            OcelotType.RED_CAT -> Ocelot.Type.RED_CAT
            OcelotType.SIAMESE_CAT -> Ocelot.Type.SIAMESE_CAT
            OcelotType.WILD_OCELOT -> Ocelot.Type.WILD_OCELOT
        }
    }
}