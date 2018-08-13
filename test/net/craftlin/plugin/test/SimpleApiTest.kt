package net.craftlin.plugin.test

import net.craftlin.plugin.api.Listener
import net.craftlin.plugin.api.Location
import net.craftlin.plugin.api.entity.Gamemode
import net.craftlin.plugin.api.entity.Player
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

            override var isFlyEnabled: Boolean
                get() = TODO("not implemented")
                set(value) {}

            override var gamemode: Gamemode
                get() = TODO("not implemented")
                set(value) {}

            override fun kick(reason: String) {
                TODO("not implemented")
            }

            override fun teleport(location: Location) {
                TODO("not implemented")
            }

            override fun ban(reason: String) {
                TODO("not implemented")
            }

            var message: String? = null
            override val name = "test"
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