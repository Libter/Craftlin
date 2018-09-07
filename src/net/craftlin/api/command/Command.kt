package net.craftlin.api.command

import net.craftlin.api.misc.thisF

class Command<Context: CommandContext>(private val definition: String, private val executor: thisF<Context>) {

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

    operator fun invoke(context: Context) {
        try {
            executor(context)
        } catch (e: CommandUsageException) {
            context.sender.message("&4Usage: $definition")
        } catch (e: CommandCustomException) {
            context.sender.message(e.message)
        }
    }

}