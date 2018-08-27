package net.craftlin.api.command

abstract class Command(val name: String, val aliases: List<String> = emptyList(), val description: String? = null) {
    abstract val executor: CommandContext.() -> Unit
}