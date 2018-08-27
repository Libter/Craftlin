package net.craftlin.api.command

import net.craftlin.api.misc.thisF

class Command(definition: String, val executor: thisF<CommandContext>) {

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

}