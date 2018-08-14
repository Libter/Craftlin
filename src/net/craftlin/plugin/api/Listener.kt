package net.craftlin.plugin.api

import net.craftlin.plugin.api.event.*
import net.craftlin.plugin.api.event.base.Handler

abstract class Listener {

    //TODO: better solution - @Redziu :P
    val joinHandler = Handler<JoinEvent>()
    val quitHandler = Handler<QuitEvent>()
    val chatHandler = Handler<ChatEvent>()
    val preLoginHandler = Handler<PreLoginEvent>()
    val blockBreakHandler = Handler<BlockBreakEvent>()

}