package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.OfflinePlayer

class BukkitOfflinePlayer(private val origin: org.bukkit.OfflinePlayer): OfflinePlayer {

    override val uuid: String get() = origin.uniqueId.toString()

    override val online: Boolean get() = origin.isOnline

    override val name: String get() = origin.name
}