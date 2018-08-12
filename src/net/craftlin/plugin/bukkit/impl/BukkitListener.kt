package net.craftlin.plugin.bukkit.impl

import net.craftlin.plugin.api.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent

class BukkitListener: Listener(), org.bukkit.event.Listener {

    @EventHandler
    fun triggerJoin(event: PlayerJoinEvent) {
        joinListeners.forEach { it(BukkitPlayer(event.player)) }
    }

}