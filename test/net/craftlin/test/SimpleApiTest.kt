package net.craftlin.test

import net.craftlin.api.entity.Player
import net.craftlin.api.event.JoinEvent
import net.craftlin.api.util.Engine
import net.craftlin.api.util.Listener
import net.craftlin.api.world.Location
import net.craftlin.test.util.EngineBasedTest
import org.junit.Assert
import org.junit.Test

class SimpleApiTest: EngineBasedTest() {

    private object JoinListener: Listener() {
        fun trigger(player: Player) = trigger<JoinEvent>(object: JoinEvent {
            override val first = false
            override var message = ""
            override val player = player
        })
    }

    object JoinVariables: EmptyVariables(JoinListener) {
        val test = "test"
    }

    @Test
    fun joinListenerTest() {
        val player = object: Player {
            override fun damage(amount: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override val online: Boolean
                get() = TODO("not implemented")

            var message: String? = null
            override fun message(message: String) {
                this.message = message
            }
            
            override var gamemode: String
                get() = TODO("not implemented") 
                set(value) {}
            override fun kick(reason: String) {
                TODO("not implemented")
            }
            override val uuid: String
                get() = TODO("not implemented") 
            override val location: Location
                get() = TODO("not implemented") 
            override var name: String
                get() = TODO("not implemented") 
                set(value) {}
            override var health: Int
                get() = TODO("not implemented") 
                set(value) {}
            override var maxHealth: Int
                get() = TODO("not implemented") 
                set(value) {}
            override var dead: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override var canPickup: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override var canCollide: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override fun teleport(location: Location) {
                TODO("not implemented")
            }
            override fun ignite(ticks: Int) {
                TODO("not implemented")
            }
            override fun igniteTime(): Int {
                TODO("not implemented")
            }
        }
        Engine.put(JoinVariables)
        Engine.run("onJoin { player.message(test) }")
        JoinListener.trigger(player)
        Assert.assertEquals("test", player.message)
    }

}