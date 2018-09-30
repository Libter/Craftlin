package net.craftlin.api.command

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.Sender
import net.craftlin.api.misc.Block
import net.craftlin.api.misc.ItBlock
import java.math.BigDecimal
import java.math.BigInteger

abstract class CommandContext(internal val command: Command, raw: String) {

    companion object {
        private val numberRegex = Regex("^\\d+$")
        private val decimalRegex = Regex("^\\d+(.\\d+)?$")
    }

    private val args = raw.run {
        substring(command.name.length).split(" ").toMutableList().apply {
            removeIf { it.isBlank() }
        }
    }

    private val exception = CommandUsageException(command)

    private fun get(key: String): String? {
        val index = command.mappings[key] ?: throw IllegalArgumentException("Invalid argument key: $key")

        return when {
            index !in 0 until args.size -> null
            command.greedy && command.mappings.keys.last() == key ->
                args.slice(index until args.size).joinToString(" ")
            else -> args[index]
        }
    }

    private fun forceGet(key: String) = get(key) ?: throw exception

    private fun parseNumber(text: String): BigInteger {
        if (!text.matches(numberRegex)) throw exception
        return BigInteger(text)
    }

    private fun parseDecimal(text: String): BigDecimal {
        if (!text.matches(decimalRegex)) throw exception
        return BigDecimal(text)
    }

    /** The command sender */
    abstract val sender: Sender

    /** Sends a message to [sender]. */
    fun message(message: String) = sender.message(message)

    /**
     * Sends an error to [sender] and terminates execution of the command.
     * @throws CommandCustomException
     */
    fun error(message: String) {
        throw CommandCustomException(command, message)
    }

    /** Checks if an argument is set by [sender]. */
    fun defined(key: String) = get(key) != null

    /**
     * @return a text specified in the argument with [key].
     * @throws CommandUsageException when the argument is unset.
     */
    fun text(key: String) = forceGet(key)

    /**
     * @return a integer number specified in the argument with [key].
     * @throws CommandUsageException when the argument is unset.
     */
    fun number(key: String) = parseNumber(text(key))

    /**
     * @return a list of integer numbers specified in the argument with [key].
     * @throws CommandUsageException when the argument is unset.
     */
    fun numberList(key: String) = text(key).split(" ").map(::parseNumber)

    /**
     * @return a decimal number specified in the argument with [key].
     * @throws CommandUsageException when the argument is unset.
     */
    fun decimal(key: String) = parseDecimal(text(key))

    /**
     * @return a list of decimal numbers specified in the argument with [key].
     * @throws CommandUsageException when the argument is unset.
     */
    fun decimalList(key: String) = text(key).split(" ").map(::parseDecimal)

    /**
     * @return a player with name specified in the argument with [key] or null if player isn't online.
     * @throws CommandUsageException when the argument is unset.
     */
    abstract fun player(key: String): Player?

    /**
     * @return a list of online players specified in the argument with [key].
     * @throws CommandUsageException when the argument is unset.
     */
    fun playerList(key: String) = text(key).split(" ").mapNotNull(::player)

    /**
     * Retrieves the offline player with name specified in the argument with key [key]
     * and calls [callback] with found player or null if player doesn't exist.
     * @throws CommandUsageException when the argument is unset.
     */
    abstract fun offlinePlayer(key: String, callback: ItBlock<OfflinePlayer?>)

    /**
     * Executes [block] if sender is not [Player] or is [Player.permitted],
     * otherwise sends message about lack of permissions
     */
    fun require(permission: String, block: Block) {
        val sender = this.sender
        if (sender !is Player || sender.permitted(permission)) {
            block()
        } else {
            sender.message("&4You need a permission to execute this action: $permission")
        }
    }
}