package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.location.Location
import net.craftlin.plugin.bukkit.extension.color
import net.craftlin.plugin.bukkit.impl.value.BukkitGameMode

class BukkitPlayer(private val origin: org.bukkit.entity.Player): Player() {

    override val name: String = origin.name

    override var gamemode: String
        get() = BukkitGameMode.toString(origin.gameMode)
        set(value) { origin.gameMode = BukkitGameMode.fromString(value) }

    override var isOp: Boolean
        get() = origin.isOp
        set(value) { origin.isOp = value }

    override fun message(message: String) = origin.sendMessage(message.color())

    override fun kick(reason: String) = origin.kickPlayer(reason.color())

    override fun teleport(location: Location) {
        origin.teleport(org.bukkit.Location(origin.world,
            location.x, location.y, location.z, location.yaw, location.pitch))
    }
}