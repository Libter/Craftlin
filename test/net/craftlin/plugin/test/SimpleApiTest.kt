package net.craftlin.plugin.test

import net.craftlin.plugin.api.Variables
import net.craftlin.plugin.api.entity.Entity
import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.api.world.Location
import net.craftlin.plugin.test.util.EngineBasedTest
import net.craftlin.plugin.util.Engine
import org.junit.Assert
import org.junit.Test

class SimpleApiTest: EngineBasedTest() {

    private object JoinListener: Listener() {
        fun trigger(player: Player) = trigger<JoinEvent>(object: JoinEvent {
            override var message = ""
            override val player = player
        })
    }

    @Test
    fun joinListenerTest() {
        val player = object: Player {
            var message: String? = null
            override val name = "test"
            override fun message(message: String) {
                this.message = message
            }
            
            override var gamemode: String
                get() = TODO("not implemented") 
                set(value) {}
            override var isOp: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override fun kick(reason: String) {
                TODO("not implemented")
            }
            override val uuid: String
                get() = TODO("not implemented") 
            override val location: Location
                get() = TODO("not implemented") 
            override var customName: String
                get() = TODO("not implemented") 
                set(value) {}
            override var health: Int
                get() = TODO("not implemented") 
                set(value) {}
            override var maxHealth: Int
                get() = TODO("not implemented") 
                set(value) {}
            override var isDead: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override var canPickupItems: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override var isCollidable: Boolean
                get() = TODO("not implemented") 
                set(value) {}
            override fun teleport(location: Location) {
                TODO("not implemented")
            }
            override fun teleport(entity: Entity) {
                TODO("not implemented")
            }
            override fun ignite(ticks: Int) {
                TODO("not implemented")
            }
            override fun igniteTime(): Int {
                TODO("not implemented")
            }
            override fun damage(amount: Int) {
                TODO("not implemented")
            }
        }
        Engine.put(object: Variables(JoinListener) {
            val test = "test"
        })
        Engine.run("onJoin { player.message(test) }")
        JoinListener.trigger(player)
        Assert.assertEquals("test", player.message)
    }

}