package net.craftlin.test.util

import net.craftlin.api.Server
import net.craftlin.api.Variables
import net.craftlin.api.command.CommandContext
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.Sender
import net.craftlin.api.misc.Timer
import net.craftlin.api.misc.emptyF
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
        override val console: Sender
            get() = object: Sender {
                override fun message(message: String) = println(message)
            }
        override val players = ArrayList<Player>()
        override val worlds = ArrayList<World>()
        override fun player(name: String): Player? = players.find { it.name == name }
        override fun offlinePlayer(name: String, callback: itF<OfflinePlayer?>) { }
    }

    open class EmptyVariables(listener: Listener = EmptyListener): Variables(listener) {
        override val command = fun (definition: String, callback: thisF<CommandContext>) { }
        override val sync: (callback: emptyF) -> Unit
            get() = fun(callback: emptyF) { callback() }
        override val async: (callback: emptyF) -> Unit
            get() = fun(callback: emptyF) { callback() }
        override val delay: (time: Long, callback: emptyF) -> Unit
            get() = fun(_: Long, callback: emptyF) { callback() }
        override val delayAsync: (time: Long, callback: emptyF) -> Unit
            get() = fun(_: Long, callback: emptyF) { callback() }
        override val timer: (interval: Long, callback: thisF<Timer>) -> Unit
            get() = fun(_: Long, callback: thisF<Timer>) { }
        override val timerAsync: (interval: Long, callback: thisF<Timer>) -> Unit
            get() = fun(_: Long, callback: thisF<Timer>) { }
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