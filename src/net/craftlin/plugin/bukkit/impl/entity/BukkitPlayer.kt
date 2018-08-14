package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.world.Location
import net.craftlin.plugin.bukkit.impl.value.BukkitGameMode
import org.bukkit.GameMode

class BukkitPlayer(private val origin: org.bukkit.entity.Player): Player() {
    private var originGameMode: GameMode
        get() = origin.gameMode
        set(value) { origin.gameMode = value }

    override val name: String = origin.name

    override var gamemode by BukkitGameMode.Delegate(::originGameMode)

    override var isOp: Boolean
        get() = origin.isOp
        set(value) { origin.isOp = value }

    override fun message(message: String) = origin.sendMessage(message)

    override fun kick(reason: String) = origin.kickPlayer(reason)

    override fun teleport(location: Location) {
        origin.teleport(org.bukkit.Location(origin.world,
            location.x, location.y, location.z, location.yaw, location.pitch))
    }
}