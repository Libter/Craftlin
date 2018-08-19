package net.craftlin.plugin.test

import net.craftlin.plugin.api.entity.Entity
import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.JoinEvent
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.api.util.Engine
import net.craftlin.plugin.api.world.Location
import net.craftlin.plugin.test.util.EngineBasedTest
import org.junit.Assert
import org.junit.Test
import java.util.Date

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
            override val online: Boolean
                get() = TODO("not implemented")
            override val banned: Boolean
                get() = TODO("not implemented")
            override var whitelisted: Boolean
                get() = TODO("not implemented")
                set(value) {}

            var message: String? = null
            override val name = "test"
            override fun message(message: String) {
                this.message = message
            }
            
            override var gamemode: String
                get() = TODO("not implemented") 
                set(value) {}
            override var op: Boolean
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
            override fun hasPermission(name: String, checkOp: Boolean): Boolean {
                TODO("not implemented")
            }
            override fun damage(amount: Int) {
                TODO("not implemented")
            }
            override fun ban(reason: String?, expires: Date?) {
                TODO("not implemented")
            }

            override fun unban() {
                TODO("not implemented")
            }
        }
        Engine.put(JoinVariables)
        Engine.run("onJoin { player.message(test) }")
        JoinListener.trigger(player)
        Assert.assertEquals("test", player.message)
    }

}