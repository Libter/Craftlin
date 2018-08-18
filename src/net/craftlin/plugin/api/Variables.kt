package net.craftlin.plugin.api

import net.craftlin.plugin.api.event.Listener

abstract class Variables(listener: Listener) {

    val beforeJoin = listener.joinHandler::add
    val onJoin = listener.joinHandler::add
    val onQuit = listener.quitHandler::add
    val onMove = listener.moveHandler::add
    val onChat = listener.chatHandler::add
    val onBreak = listener.breakHandler::add
    val onPlace = listener.placeHandler::add

}