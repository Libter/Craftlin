package net.craftlin.plugin.api

import net.craftlin.plugin.api.event.BeforeJoinEvent
import net.craftlin.plugin.api.event.BreakEvent
import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.api.event.MoveEvent
import net.craftlin.plugin.api.event.PlaceEvent
import net.craftlin.plugin.api.event.QuitEvent

abstract class Variables(listener: Listener) {

    abstract val server: Server

    abstract val sync: (callback: () -> Unit) -> Unit
    abstract val async: (callback: () -> Unit) -> Unit
    abstract val delay: (time: Long, callback: () -> Unit) -> Unit
    abstract val delayAsync: (time: Long, callback: () -> Unit) -> Unit
    abstract val timer: (interval: Long, callback: () -> Unit) -> Unit
    abstract val timerAsync: (interval: Long, callback: () -> Unit) -> Unit

    val beforeJoin = listener.add<BeforeJoinEvent>()
    val onJoin = listener.add<JoinEvent>()
    val onQuit = listener.add<QuitEvent>()
    val onMove = listener.add<MoveEvent>()
    val onChat = listener.add<ChatEvent>()
    val onBreak = listener.add<BreakEvent>()
    val onPlace = listener.add<PlaceEvent>()

}