package net.craftlin.plugin.test.util

import net.craftlin.plugin.api.event.Listener
import net.craftlin.plugin.util.Engine
import net.craftlin.plugin.util.Logger
import org.junit.BeforeClass

abstract class EngineBasedTest {

    protected object EmptyListener: Listener()

    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            Logger.reset()
            Engine.load()
        }
    }

}