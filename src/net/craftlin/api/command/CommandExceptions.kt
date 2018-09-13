package net.craftlin.api.command

abstract class CommandException(val command: Command): RuntimeException()

class CommandUsageException(command: Command): CommandException(command)

class CommandCustomException(command: Command, override val message: String): CommandException(command)