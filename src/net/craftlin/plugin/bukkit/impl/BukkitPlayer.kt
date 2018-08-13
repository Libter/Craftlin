package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.Location
import net.craftlin.plugin.api.entity.Gamemode
import net.craftlin.plugin.api.entity.Player

class BukkitPlayer(private val origin: org.bukkit.entity.Player): Player {

    override var isFlyEnabled: Boolean
        get() = TODO("not implemented")
        set(value) {}

    override var gamemode: Gamemode
        get() = TODO("not implemented")
        set(value) {}

    override fun kick(reason: String) {
        TODO("not implemented")
    }

    override fun teleport(location: Location) {
        TODO("not implemented")
    }

    override fun ban(reason: String) {
        TODO("not implemented")
    }

    override val name: String = origin.name

    override fun message(message: String) = origin.sendMessage(message)
}