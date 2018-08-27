package net.craftlin.api

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.entity.Player
import net.craftlin.api.world.World

interface Server {
    val players: List<Player>
    val worlds: List<World>
    val craftlinCommands: List<Command>

    fun registerCommand(command: Command, pattern: String = "")

    fun registerCommand(name: String, pattern: String = "", aliases: List<String> = emptyList(), description: String? = null, executor: CommandContext.() -> Unit) {
        registerCommand(object: Command(name, aliases, description) {
            override val executor = executor
        }, pattern)
    }
}