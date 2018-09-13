package net.craftlin.api.util

import net.craftlin.api.command.Command

abstract class Commands {

    private val list = ArrayList<Command>()

    operator fun get(name: String) = list.firstOrNull {
        name.startsWith(it.name + " ") || name == it.name
    }
    fun add(command: Command) { list.add(command) }
    fun clear() { list.clear() }

}