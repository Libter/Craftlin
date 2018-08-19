package net.craftlin.test.util

import net.craftlin.api.Server
import net.craftlin.api.Variables
import net.craftlin.api.entity.Player
import net.craftlin.api.misc.Timer
import net.craftlin.api.misc.itF
import net.craftlin.api.misc.thisF
import net.craftlin.api.util.Engine
import net.craftlin.api.util.Listener
import net.craftlin.api.util.Logger
import net.craftlin.api.world.World
import org.junit.BeforeClass

abstract class EngineBasedTest {

    protected object EmptyListener: Listener()

    object EmptyServer: Server {
        override val players = ArrayList<Player>()
        override val worlds = ArrayList<World>()
    }

    object EmptyTimer: Timer() {
        override fun stop() { }
    }

    open class EmptyVariables(listener: Listener = EmptyListener): Variables(listener) {
        override val sync: (callback: itF) -> Unit
            get() = fun(callback: itF) { callback() }
        override val async: (callback: itF) -> Unit
            get() = fun(callback: itF) { callback() }
        override val delay: (time: Long, callback: itF) -> Unit
            get() = fun(_: Long, callback: itF) { callback() }
        override val delayAsync: (time: Long, callback: itF) -> Unit
            get() = fun(_: Long, callback: itF) { callback() }
        override val timer: (interval: Long, callback: thisF<Timer>) -> Unit
            get() = fun(_: Long, callback: thisF<Timer>) { callback(EmptyTimer) }
        override val timerAsync: (interval: Long, callback: thisF<Timer>) -> Unit
            get() = fun(_: Long, callback: thisF<Timer>) { callback(EmptyTimer) }
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