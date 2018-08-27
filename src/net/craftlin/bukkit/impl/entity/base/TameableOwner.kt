package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.bukkit.impl.entity.BukkitOfflinePlayer
import org.bukkit.entity.Tameable
import kotlin.reflect.KProperty

class TameableOwner(private val origin: Tameable) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): OfflinePlayer? {
        val offlinePlayer = origin.owner as? org.bukkit.OfflinePlayer ?: return null
        return BukkitOfflinePlayer(offlinePlayer)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: OfflinePlayer?) {
        if (value !is BukkitOfflinePlayer) return
        origin.owner = value.origin
    }

}