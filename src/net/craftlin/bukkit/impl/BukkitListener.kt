package net.craftlin.bukkit.impl

import net.craftlin.api.event.AirClickEvent
import net.craftlin.api.event.BeforeJoinEvent
import net.craftlin.api.event.BlockClickEvent
import net.craftlin.api.event.BreakEvent
import net.craftlin.api.event.ButtonPressEvent
import net.craftlin.api.event.ChatEvent
import net.craftlin.api.event.ClickEvent
import net.craftlin.api.event.EntityClickEvent
import net.craftlin.api.event.JoinEvent
import net.craftlin.api.event.LeaveEvent
import net.craftlin.api.event.LeverPullEvent
import net.craftlin.api.event.MoveEvent
import net.craftlin.api.event.PlaceEvent
import net.craftlin.api.event.PressurePlateEvent
import net.craftlin.api.event.SoilJumpEvent
import net.craftlin.api.event.TripwireEvent
import net.craftlin.api.util.Listener
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerQuitEvent
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
    fun triggerMove(event: PlayerMoveEvent) = trigger<MoveEvent>(BukkitMoveEvent(event))

    @EventHandler
    fun triggerEntityClick(event: PlayerInteractEntityEvent) {
        with(BukkitEntityClickEvent(event)) {
            trigger<EntityClickEvent>(this)
            trigger<ClickEvent>(this)
        }
    }

    @EventHandler
    fun triggerInteractEvents(origin: PlayerInteractEvent) {
        val action = origin.action ?: return
        val right = action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR
        when (action) {
            Action.LEFT_CLICK_BLOCK,
            Action.RIGHT_CLICK_BLOCK -> {
                val block = origin.clickedBlock ?: return
                val event: BlockClickEvent
                when {
                    right && block.state.data is Button -> {
                        event = BukkitButtonPressEvent(origin)
                        trigger<ButtonPressEvent>(event)
                    }
                    right && block.state.data is Lever -> {
                        event = BukkitLeverPullEvent(origin)
                        trigger<LeverPullEvent>(event)
                    }
                    else -> event = BukkitBlockClickEvent(origin)
                }
                trigger<BlockClickEvent>(event)
                trigger<ClickEvent>(event)
            }
            Action.LEFT_CLICK_AIR,
            Action.RIGHT_CLICK_AIR -> {
                val event = BukkitAirClickEvent(origin)
                trigger<AirClickEvent>(event)
                trigger<ClickEvent>(event)
            }
            Action.PHYSICAL -> {
                when (origin.clickedBlock?.type) {
                    Material.OAK_PRESSURE_PLATE,
                    Material.SPRUCE_PRESSURE_PLATE,
                    Material.BIRCH_PRESSURE_PLATE,
                    Material.JUNGLE_PRESSURE_PLATE,
                    Material.ACACIA_PRESSURE_PLATE,
                    Material.DARK_OAK_PRESSURE_PLATE,
                    Material.STONE_PRESSURE_PLATE,
                    Material.LIGHT_WEIGHTED_PRESSURE_PLATE,
                    Material.HEAVY_WEIGHTED_PRESSURE_PLATE -> {
                        trigger<PressurePlateEvent>(BukkitPressurePlateEvent(origin))
                    }
                    Material.FARMLAND -> {
                        trigger<SoilJumpEvent>(BukkitSoilJumpEvent(origin))
                    }
                    Material.TRIPWIRE -> {
                        trigger<TripwireEvent>(BukkitTripwireEvent(origin))
                    }
                    else -> { /*TODO: more physical events */ }
                }
            }
        }
    }
}