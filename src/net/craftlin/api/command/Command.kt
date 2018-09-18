package net.craftlin.api.command

import net.craftlin.api.misc.ThisBlock
import net.craftlin.api.misc.ThisResultBlock

class Command(private val definition: String, private val executor: ThisBlock<CommandContext>) {

    companion object {
        fun alias(definition: String, executor: ThisResultBlock<CommandContext, String>): Command {
            return Command(definition) {
                val splitted = executor(this).split(" ").toMutableList()
                for (i in 1 until splitted.size) {
                    val key = splitted[i]
                    if (command.mappings.contains(key)) {
                        splitted[i] = text(key)
                    }
                }
                sender.command(splitted.joinToString(" "))
            }
        }
    }

    val name: String
    val mappings = HashMap<String,Int>()

    init {
        try {
            val splitted = definition.split(" ")
            name = splitted[0]
            for (i in 1 until splitted.size) {
                mappings[splitted[i]] = i - 1
            }
        } catch (throwable: Throwable) {
            throw IllegalArgumentException("Invalid command definition: $definition")
        }
    }

    operator fun invoke(context: CommandContext) {
        try {
            executor(context)
        } catch (e: CommandUsageException) {
            context.sender.message("&4Usage: $definition")
        } catch (e: CommandCustomException) {
            context.sender.message(e.message)
        } catch (e: Throwable) {
            context.sender.message("&4An internal error occurred, contact the server admin!")
            e.printStackTrace()
            //TODO: save error to file
        }
    }

}