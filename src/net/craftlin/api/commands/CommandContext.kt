package net.craftlin.api.commands

import net.craftlin.api.entity.Sender

data class CommandContext(val sender: Sender, val args: CommandArguments)