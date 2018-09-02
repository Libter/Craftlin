package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.entity.modifier.EffectType
import org.bukkit.potion.PotionEffectType

object BukkitEffectType: EnumValue<EffectType, PotionEffectType>(EffectType::class) {
    override fun convert(api: EffectType) = when (api) {
        EffectType.ABSORPTION -> PotionEffectType.ABSORPTION
        EffectType.BLINDNESS -> PotionEffectType.BLINDNESS
        EffectType.CONDUIT_POWER -> PotionEffectType.CONDUIT_POWER
        EffectType.CONFUSION -> PotionEffectType.CONFUSION
        EffectType.DAMAGE_RESISTANCE -> PotionEffectType.DAMAGE_RESISTANCE
        EffectType.DOLPHINS_GRACE -> PotionEffectType.DOLPHINS_GRACE
        EffectType.FAST_DIGGING -> PotionEffectType.FAST_DIGGING
        EffectType.FIRE_RESISTANCE -> PotionEffectType.FIRE_RESISTANCE
        EffectType.GLOWING -> PotionEffectType.GLOWING
        EffectType.HARM -> PotionEffectType.HARM
        EffectType.HEAL -> PotionEffectType.HEAL
        EffectType.HEALTH_BOOST -> PotionEffectType.HEALTH_BOOST
        EffectType.HUNGER -> PotionEffectType.HUNGER
        EffectType.INCREASE_DAMAGE -> PotionEffectType.INCREASE_DAMAGE
        EffectType.INVISIBILITY -> PotionEffectType.INVISIBILITY
        EffectType.JUMP -> PotionEffectType.JUMP
        EffectType.LEVITATION -> PotionEffectType.LEVITATION
        EffectType.LUCK -> PotionEffectType.LUCK
        EffectType.NIGHT_VISION -> PotionEffectType.NIGHT_VISION
        EffectType.POISON -> PotionEffectType.POISON
        EffectType.REGENERATION -> PotionEffectType.REGENERATION
        EffectType.SATURATION -> PotionEffectType.SATURATION
        EffectType.SLOW -> PotionEffectType.SLOW
        EffectType.SLOW_DIGGING -> PotionEffectType.SLOW_DIGGING
        EffectType.SLOW_FALLING -> PotionEffectType.SLOW_FALLING
        EffectType.SPEED -> PotionEffectType.SPEED
        EffectType.UNLUCK -> PotionEffectType.UNLUCK
        EffectType.WATER_BREATHING -> PotionEffectType.WATER_BREATHING
        EffectType.WEAKNESS -> PotionEffectType.WEAKNESS
        EffectType.WITHER -> PotionEffectType.WITHER
    }
}