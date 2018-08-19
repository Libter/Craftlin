package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.RabbitType
import org.bukkit.entity.Rabbit

object BukkitRabbitType: EnumValue<RabbitType, Rabbit.Type>(RabbitType::class) {
    override fun convert(api: RabbitType): Rabbit.Type {
        return when (api) {
            RabbitType.BLACK -> Rabbit.Type.BLACK
            RabbitType.BLACK_AND_WHITE -> Rabbit.Type.BLACK_AND_WHITE
            RabbitType.BROWN -> Rabbit.Type.BROWN
            RabbitType.GOLD -> Rabbit.Type.GOLD
            RabbitType.SALT_AND_PEPPER -> Rabbit.Type.SALT_AND_PEPPER
            RabbitType.THE_KILLER_BUNNY -> Rabbit.Type.THE_KILLER_BUNNY
            RabbitType.WHITE -> Rabbit.Type.WHITE
        }
    }
}