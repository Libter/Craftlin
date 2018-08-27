package net.craftlin.api.value

import net.craftlin.bukkit.impl.value.BukkitEffectType
import org.bukkit.potion.PotionEffectType

class Effect(
    var originType: PotionEffectType,
    var time: Long,
    var strength: Long = 1,
    var ambient: Boolean = false,
    var particles: Boolean = true,
    var icon: Boolean = true
): Cloneable {

    val type by BukkitEffectType.Delegate(::originType)

    fun copy(newTime: Long) = clone().apply { time = newTime }

}