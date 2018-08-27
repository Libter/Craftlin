package net.craftlin.api.command

import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.Sender
import java.math.BigDecimal
import java.math.BigInteger

abstract class CommandContext(private val command: Command, private val args: Array<String>) {

    companion object {
        private val numberRegex = Regex("^\\d+$")
        private val decimalRefex = Regex("^\\d+(.\\d+)?$")
    }

    abstract val sender: Sender

    protected val exception = CommandUsageException(command)

    protected fun get(key: String): String? {
        val index = command.mappings[key] ?: throw IllegalArgumentException("Invalid argument key: $key")
        return if (index in 0 until args.size) args[index] else null
    }

    protected fun forceGet(key: String) = get(key) ?: throw exception

    fun defined(key: String) = get(key) != null

    fun text(key: String) = forceGet(key)

    fun number(key: String): BigInteger {
        val text = text(key)
        if (!text.matches(numberRegex)) throw exception
        return BigInteger(text)
    }

    fun decimal(key: String): BigDecimal {
        val text = text(key)
        if (!text.matches(decimalRefex)) throw exception
        return BigDecimal(text)
    }

    abstract fun player(key: String): Player

    abstract fun offlinePlayer(key: String): OfflinePlayer

}