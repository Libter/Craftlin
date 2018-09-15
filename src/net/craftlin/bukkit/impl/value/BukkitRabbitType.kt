package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.entity.RabbitVariant
import org.bukkit.entity.Rabbit

object BukkitRabbitType: EnumValue<RabbitVariant, Rabbit.Type>(RabbitVariant::class) {
    override fun Converter(api: RabbitVariant) = when (api) {
        RabbitVariant.BLACK -> Rabbit.Type.BLACK
        RabbitVariant.BLACK_AND_WHITE -> Rabbit.Type.BLACK_AND_WHITE
        RabbitVariant.BROWN -> Rabbit.Type.BROWN
        RabbitVariant.GOLD -> Rabbit.Type.GOLD
        RabbitVariant.SALT_AND_PEPPER -> Rabbit.Type.SALT_AND_PEPPER
        RabbitVariant.THE_KILLER_BUNNY -> Rabbit.Type.THE_KILLER_BUNNY
        RabbitVariant.WHITE -> Rabbit.Type.WHITE
    }
}