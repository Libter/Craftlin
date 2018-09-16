package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Player
import net.craftlin.bukkit.impl.entity.base.BukkitLivingEntity
import net.craftlin.bukkit.impl.value.BukkitGameMode
import org.bukkit.GameMode

class BukkitPlayer(private val origin: org.bukkit.entity.Player): BukkitLivingEntity(origin), Player {
    private val sender = BukkitSender(origin)

    private var originGameMode: GameMode
        get() = origin.gameMode
        set(value) { origin.gameMode = value }

    override var name
        get() = origin.name
        set(_) { }

    override val online get() = origin.isOnline

    override var gamemode by BukkitGameMode.Delegate(::originGameMode)

    override fun kick(reason: String) = origin.kickPlayer(reason)

    override fun message(message: String) = sender.message(message)
    override fun command(command: String) = sender.command(command)

}