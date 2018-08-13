package net.craftlin.plugin.test

import net.craftlin.plugin.api.Listener
import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.value.Location
import net.craftlin.plugin.test.util.EngineBasedTest
import net.craftlin.plugin.util.Engine
import org.junit.Assert
import org.junit.Test

class SimpleApiTest: EngineBasedTest() {

    @Test
    fun joinListenerTest() {
        val listener = object: Listener() {
            fun trigger(player: Player) = joinHandler.trigger(object: JoinEvent() {
                override var message = ""
                override val player = player
            })
        }
        val player = object: Player() {
            override var gamemode: String
                get() = "survival"
                set(value) {}

            override fun kick(reason: String) { }

            override fun teleport(location: Location) { }

            var message: String? = null
            override val name = "test"
            override fun message(message: String) {
                this.message = message
            }
        }
        Engine.variables(mapOf(
            "test" to "test",
            "onJoin" to listener.joinHandler::add
        ))
        Engine.run("onJoin { player.message(test) }")
        listener.trigger(player)
        Assert.assertEquals("test", player.message)
    }

}