package net.craftlin.plugin.api

import net.craftlin.plugin.api.event.BreakEvent
import net.craftlin.plugin.api.event.ChatEvent
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.PreLoginEvent
import net.craftlin.plugin.api.event.QuitEvent
import net.craftlin.plugin.api.event.base.Handler

abstract class Listener {

    //TODO: better solution - @Redziu :P
    val joinHandler = Handler<JoinEvent>()
    val quitHandler = Handler<QuitEvent>()
    val chatHandler = Handler<ChatEvent>()
    val preLoginHandler = Handler<PreLoginEvent>()
    val blockBreakHandler = Handler<BreakEvent>()

}