package net.craftlin.api.command

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.Sender
import net.craftlin.api.misc.itF
import java.math.BigDecimal
import java.math.BigInteger

abstract class CommandContext(private val command: Command<*>, private val args: Array<String>) {

    companion object {
        private val numberRegex = Regex("^\\d+$")
        private val decimalRefex = Regex("^\\d+(.\\d+)?$")
    }

    /**
     * The command sender
     */
    abstract val sender: Sender

    protected val exception = CommandUsageException(command)

    protected fun get(key: String): String? {
        val index = command.mappings[key] ?: throw IllegalArgumentException("Invalid argument key: $key")
        return if (index in 0 until args.size) args[index] else null
    }

    protected fun forceGet(key: String) = get(key) ?: throw exception

    /**
     * Sends a message to [sender].
     */
    fun message(message: String) = sender.message(message)

    /**
     * Sends an error to [sender] and terminates execution of the command.
     *
     * @throws CommandCustomException
     */
    fun error(message: String) {
        throw CommandCustomException(command, message)
    }

    /**
     * Is an argument (and its [key]) defined?
     */
    fun defined(key: String) = get(key) != null

    /**
     * Returns a text specified in the argument with key [key]
     *
     * @throws CommandUsageException when the argument is unset or key is invalid.
     */
    fun text(key: String) = forceGet(key)

    /**
     * Returns a number specified in the argument with key [key]
     *
     * @throws CommandUsageException when the argument is unset or key is invalid.
     */
    fun number(key: String): BigInteger {
        val text = text(key)
        if (!text.matches(numberRegex)) throw exception
        return BigInteger(text)
    }

    /**
     * Returns a decimal specified in the argument with key [key]
     *
     * @throws CommandUsageException when the argument is unset or key is invalid.
     */
    fun decimal(key: String): BigDecimal {
        val text = text(key)
        if (!text.matches(decimalRefex)) throw exception
        return BigDecimal(text)
    }

    /**
     * Returns the player with name specified in the argument with key [key]
     *
     * @throws CommandUsageException when the argument is unset or key is invalid.
     */
    abstract fun player(key: String): Player

    /**
     * Retrieves the offline player with name specified in the argument with key [key]
     *
     * @throws CommandUsageException when the argument is unset or key is invalid.
     */
    abstract fun offlinePlayer(key: String, callback: itF<OfflinePlayer?>)
}