package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.Player

class BukkitPlayer(private val origin: org.bukkit.entity.Player): Player {
    override val nick: String get() = origin.name

    override fun message(message: String) = origin.sendMessage(message)
}