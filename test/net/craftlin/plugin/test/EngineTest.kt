package net.craftlin.plugin.test

import net.craftlin.plugin.test.util.EngineBasedTest
import net.craftlin.plugin.util.Engine
import org.junit.Assert
import org.junit.Test

class EngineTest: EngineBasedTest() {

    @Test
    fun setupTest() {
        setup()
        Assert.assertEquals(4, Engine.run("2 + 2"))
    }

    @Test
    fun variablesTest() {
        Engine.put(object: EmptyVariables()  {
            val test1 = "hello"
            val test2 = "world"
        })
        Assert.assertEquals("hello world", Engine.run("""test1 + " " + test2"""))
    }

    @Test
    fun primitivesTest() {
        val b: Byte = 1; val s: Short = 1
        val i: Int = 1; val l: Long = 1
        val f: Float = 1.0f; val d: Double = 1.0
        Engine.put(object: EmptyVariables()  {
            val bool = true
            val string = "test"
            val b: Byte = 1
            val s: Short = 1
            val i: Int = 1
            val l: Long = 1
            val f: Float = 1.0f
            val d: Double = 1.0
        })
        Assert.assertEquals("truetest6.0", Engine.run("bool.toString() + string + " +
            "(b.toDouble() + s.toDouble() + i.toDouble() + l.toDouble() + f.toDouble() + d.toDouble()).toString()"
        ))
    }

    @Test
    fun functionTest() {
        fun functionCallback(string: String) = "Hello $string"
        Engine.put(object: EmptyVariables() {
            val functionCallback = ::functionCallback
        })
        Assert.assertEquals("Hello world", Engine.run("""functionCallback("world")"""))
    }

}