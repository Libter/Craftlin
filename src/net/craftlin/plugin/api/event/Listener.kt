package net.craftlin.plugin.api.event

import net.craftlin.plugin.api.event.base.Handler

abstract class Listener {

    //TODO: better solution
    val beforeJoinHandler = Handler<BeforeJoinEvent>()
    val joinHandler = Handler<JoinEvent>()
    val quitHandler = Handler<QuitEvent>()
    val moveHandler = Handler<MoveEvent>()
    val chatHandler = Handler<ChatEvent>()
    val breakHandler = Handler<BreakEvent>()
    val placeHandler = Handler<PlaceEvent>()

}