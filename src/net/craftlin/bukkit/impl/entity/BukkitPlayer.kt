package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Player
import net.craftlin.api.util.chat
import net.craftlin.api.world.Sound
import net.craftlin.bukkit.impl.entity.base.BukkitLivingEntity
import net.craftlin.bukkit.impl.value.BukkitGameMode
import net.craftlin.bukkit.impl.value.BukkitSoundType
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

    override fun kick(reason: String) = origin.kickPlayer(reason.chat)

    override fun message(message: String) = sender.message(message)
    override fun command(command: String) = sender.command(command)
    override fun permitted(permission: String) = origin.hasPermission(permission)

    override fun sound(sound: Sound) = origin.playSound(
        origin.location,
        BukkitSoundType.Converter(sound.type),
        sound.volume.toFloat(),
        sound.pitch.toFloat()
    )

}