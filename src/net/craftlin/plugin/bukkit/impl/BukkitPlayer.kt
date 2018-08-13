package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.value.Location
import net.craftlin.plugin.bukkit.impl.value.BukkitGameMode

class BukkitPlayer(private val origin: org.bukkit.entity.Player): Player() {

    override val name: String = origin.name

    override var gamemode: String
        get() = BukkitGameMode.toString(origin.gameMode)
        set(value) { origin.gameMode = BukkitGameMode.fromString(value) }

    override fun message(message: String) = origin.sendMessage(message)

    override fun kick(reason: String) = origin.kickPlayer(reason)

    override fun teleport(location: Location) {
        origin.teleport(org.bukkit.Location(origin.world,
            location.x, location.y, location.z, location.yaw, location.pitch))
    }
}