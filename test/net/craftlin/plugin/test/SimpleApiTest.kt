package net.craftlin.plugin.test

import net.craftlin.plugin.api.Listener
import net.craftlin.plugin.api.Player
import net.craftlin.plugin.test.util.EngineBasedTest
import net.craftlin.plugin.util.Engine
import org.junit.Assert
import org.junit.Test

class SimpleApiTest: EngineBasedTest() {

    @Test
    fun joinListenerTest() {
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
        Assert.assertEquals("test", player.message)
    }

}