package net.craftlin.plugin.api

interface Player {
    val nick: String
    fun message(message: String)
}