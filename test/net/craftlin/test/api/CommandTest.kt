package net.craftlin.test.api

import net.craftlin.api.command.Command
import net.craftlin.test.util.EngineBasedTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CommandTest {

    @Test
    fun testGreedyArg() {
        var result1 = ""; var result2 = ""; var result3 = ""
        val command = Command("/test 1 2 3...") {
            result1 = text("1")
            result2 = text("2")
            result3 = text("3")
        }
        command(EngineBasedTest.EmptyContext(command, "/test test1 test2 test3 test4 test5"))
        assertEquals(result1, "test1")
        assertEquals(result2, "test2")
        assertEquals(result3, "test3 test4 test5")
    }

}