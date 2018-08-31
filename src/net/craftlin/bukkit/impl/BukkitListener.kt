package net.craftlin.bukkit.impl

import net.craftlin.api.event.*
import net.craftlin.api.util.Listener
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.*
import org.bukkit.material.Button
import org.bukkit.material.Lever

class BukkitListener: Listener(), org.bukkit.event.Listener {

    @EventHandler
    fun triggerJoin(event: PlayerJoinEvent) = trigger<JoinEvent>(BukkitJoinEvent(event))

    @EventHandler
    fun triggerQuit(event: PlayerQuitEvent) = trigger<LeaveEvent>(BukkitLeaveEvent(event))

    @EventHandler
    fun triggerChat(event: AsyncPlayerChatEvent) = trigger<ChatEvent>(BukkitChatEvent(event))

    @EventHandler
    fun triggerBeforeLogin(event: AsyncPlayerPreLoginEvent) = trigger<BeforeJoinEvent>(BukkitBeforeLoginEvent(event))

    @EventHandler
    fun triggerBreak(event: BlockBreakEvent) = trigger<BreakEvent>(BukkitBreakEvent(event))

    @EventHandler
    fun triggerPlace(event: BlockPlaceEvent) = trigger<PlaceEvent>(BukkitPlaceEvent(event))

    @EventHandler
    fun triggerPlayerInteractEvents(event: PlayerInteractEvent) {
        if (event.action.name.endsWith("_CLICK_BLOCK")) {
            var craftlinEvent: BlockClickEvent
            if (event.action == Action.RIGHT_CLICK_BLOCK) {
                when {
                    event.clickedBlock.state.data is Button -> {
                        craftlinEvent = BukkitButtonPressEvent(event)
                        trigger<ButtonPressEvent>(craftlinEvent)
                    }
                    event.clickedBlock.state.data is Lever -> {
                        craftlinEvent = BukkitLeverPullEvent(event)
                        trigger<LeverPullEvent>(craftlinEvent)
                    }
                    else -> craftlinEvent = BukkitBlockClickEvent(event)
                }
            } else {
                craftlinEvent = BukkitBlockClickEvent(event)
            }
            trigger<BlockClickEvent>(craftlinEvent)
            trigger<ClickEvent>(craftlinEvent)
        } else if (event.action == Action.PHYSICAL) {
            if (event.clickedBlock != null) return // TODO: other physical interact events
            if (event.clickedBlock.type.name.endsWith("_PRESSURE_PLATE")) {
                trigger<PressurePlateEvent>(BukkitPressurePlateEvent(event))
            } else if (event.clickedBlock.type == Material.FARMLAND) {
                trigger<SoilJumpEvent>(BukkitSoilJumpEvent(event))
            }
        }
    }

    @EventHandler
    fun triggerEntityClickEvent(event: PlayerInteractEntityEvent) {
        with(BukkitEntityClickEvent(event)) {
            trigger<EntityClickEvent>(this)
            trigger<ClickEvent>(this)
        }
    }
}