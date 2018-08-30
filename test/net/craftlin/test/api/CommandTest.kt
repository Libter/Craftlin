package net.craftlin.test.api

import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.command.CommandUsageException
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.misc.itF
import net.craftlin.test.util.assertThrows
import org.junit.Assert.assertEquals
import org.junit.Test

class CommandTest {

    private var outer: String = ""
    private val command = Command("/test text number decimal") {
        outer = text("text") + number("number") + decimal("decimal")
    }

    private inner class Context(vararg args: String): CommandContext(command, args as Array<String>) {
        override val sender get() = throw NotImplementedError()
        override fun player(key: String) = throw NotImplementedError()
        override fun offlinePlayer(key: String, callback: itF<OfflinePlayer?>) = throw NotImplementedError()
    }

    @Test
    fun argsTest() {
        command.executor(Context("test", "123", "1.23"))
        assertEquals("test1231.23", outer)

        assertThrows(CommandUsageException::class) {
            command.executor(Context("test", "123"))
        }
    }

    @Test
    fun numbersTest() {
        command.executor(Context("test", "123", "321"))
        assertEquals("test123321", outer)

        assertThrows(CommandUsageException::class) {
            command.executor(Context("test", "1.23", "1"))
        }

        assertThrows(CommandUsageException::class) {
            command.executor(Context("test", "1e10", "1.23"))
        }

        assertThrows(CommandUsageException::class) {
            command.executor(Context("test", "1", "1.23e10"))
        }
    }

}