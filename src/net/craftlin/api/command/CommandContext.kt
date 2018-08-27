package net.craftlin.api.command

import net.craftlin.api.entity.Sender

data class CommandContext(val sender: Sender, val args: CommandArguments)