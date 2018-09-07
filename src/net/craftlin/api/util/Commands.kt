package net.craftlin.api.util

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext

abstract class Commands<Context: CommandContext> {

    private val list = ArrayList<Command<Context>>()

    operator fun get(name: String) = list.firstOrNull {
        name.startsWith(it.name + " ") || name == it.name
    }
    fun add(command: Command<Context>) { list.add(command) }
    fun clear() { list.clear() }

}