package net.craftlin.api.commands

abstract class Command(val name: String, val aliases: List<String> = emptyList(), val description: String? = null) {
    abstract val executor: CommandContext.() -> Unit
}