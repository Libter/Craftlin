package net.craftlin.plugin.test.util

import net.craftlin.plugin.api.Server
import net.craftlin.plugin.api.Variables
import net.craftlin.plugin.api.entity.Player
import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.api.world.World
import net.craftlin.plugin.util.Engine
import net.craftlin.plugin.util.Logger
import org.junit.BeforeClass

abstract class EngineBasedTest {

    protected object EmptyListener: Listener()

    protected object EmptyServer: Server {
        override val players: List<Player>
            get() = TODO("not implemented")
        override val worlds: List<World>
            get() = TODO("not implemented")
    }

    protected open class EmptyVariables: Variables(EmptyListener) {
        override val sync: (callback: () -> Unit) -> Unit
            get() = TODO("not implemented") 
        override val async: (callback: () -> Unit) -> Unit
            get() = TODO("not implemented") 
        override val delay: (time: Long, callback: () -> Unit) -> Unit
            get() = TODO("not implemented") 
        override val delayAsync: (time: Long, callback: () -> Unit) -> Unit
            get() = TODO("not implemented") 
        override val timer: (interval: Long, callback: () -> Unit) -> Unit
            get() = TODO("not implemented") 
        override val timerAsync: (interval: Long, callback: () -> Unit) -> Unit
            get() = TODO("not implemented") 
        override val server = EmptyServer
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            Logger.reset()
            Engine.load()
        }
    }

}