package net.craftlin.test.util

import net.craftlin.api.Server
import net.craftlin.api.Variables
import net.craftlin.api.command.Command
import net.craftlin.api.command.CommandContext
import net.craftlin.api.entity.OfflinePlayer
import net.craftlin.api.entity.Player
import net.craftlin.api.entity.Sender
import net.craftlin.api.misc.Block
import net.craftlin.api.misc.ItBlock
import net.craftlin.api.misc.ThisBlock
import net.craftlin.api.misc.Timer
import net.craftlin.api.util.Commands
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
                override fun command(command: String) { }
                override fun message(message: String) = println(message)
            }
        override val players = ArrayList<Player>()
        override val worlds = ArrayList<World>()
        override fun player(name: String): Player? = players.find { it.name == name }
        override fun offlinePlayer(name: String, callback: ItBlock<OfflinePlayer?>) { }
    }

    object EmptyCommands: Commands()

    open class EmptyContext(command: Command, raw: String): CommandContext(command, raw) {
        override val sender = EmptyServer.console
        override fun player(key: String): Player { TODO() }

        override fun offlinePlayer(key: String, callback: ItBlock<OfflinePlayer?>) { }
    }

    open class EmptyVariables(listener: Listener = EmptyListener): Variables(listener, EmptyCommands) {
        override val sync: (callback: Block) -> Unit
            get() = fun(callback: Block) { callback() }
        override val async: (callback: Block) -> Unit
            get() = fun(callback: Block) { callback() }
        override val delay: (time: Long, callback: Block) -> Unit
            get() = fun(_: Long, callback: Block) { callback() }
        override val delayAsync: (time: Long, callback: Block) -> Unit
            get() = fun(_: Long, callback: Block) { callback() }
        override val timer: (interval: Long, callback: ThisBlock<Timer>) -> Unit
            get() = fun(_: Long, callback: ThisBlock<Timer>) { }
        override val timerAsync: (interval: Long, callback: ThisBlock<Timer>) -> Unit
            get() = fun(_: Long, callback: ThisBlock<Timer>) { }
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