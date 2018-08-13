package net.craftlin.plugin.test

import net.craftlin.plugin.api.Listener
import net.craftlin.plugin.api.Player
import net.craftlin.plugin.util.Engine
import net.craftlin.plugin.util.Logger
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

class TestCraftlin {

    companion object {
        @BeforeClass @JvmStatic
        fun setup() {
            Logger.reset()
            Engine.load()
        }
    }

    @Test
    fun basicTest() {
        assertEquals(4, Engine.run("2 + 2"))
    }

    @Test
    fun variableTest() {
        Engine.variables(mapOf(
            "test1" to "hello",
            "test2" to "world"
        ))
        assertEquals("hello world", Engine.run("""test1 + " " + test2"""))
    }

    @Test
    fun functionTest() {
        fun functionCallback() = "test"
        Engine.variables(mapOf(
            "functionCallback" to ::functionCallback
        ))
        assertEquals("test", Engine.run("functionCallback()"))
    }

    @Test
    fun listenerTest() {
        val listener = object: Listener() {
            fun trigger(player: Player) = joinListeners.forEach { it(player) }
        }
        val player = object: Player {
            var message: String? = null
            override val nick = "test"
            override fun message(message: String) {
                this.message = message
            }
        }
        Engine.variables(mapOf(
            "test" to "test",
            "onJoin" to listener::onJoin
        ))
        Engine.run("onJoin { it.message(test) }")
        listener.trigger(player)
        assertEquals("test", player.message)
    }

}