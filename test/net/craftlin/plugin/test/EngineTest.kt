package net.craftlin.plugin.test

import net.craftlin.plugin.test.util.EngineBasedTest
import net.craftlin.plugin.util.Engine
import org.junit.Assert
import org.junit.Test

class EngineTest: EngineBasedTest() {

    @Test
    fun setupTest() {
        Engine.load()
        Assert.assertEquals(4, Engine.run("2 + 2"))

    }

    @Test
    fun variablesTest() {
        Engine.variables(mapOf("test1" to "hello", "test2" to "world"))
        Assert.assertEquals("hello world", Engine.run("""test1 + " " + test2"""))
    }

    @Test
    fun primitivesTest() {
        val b: Byte = 1; val s: Short = 1
        val i: Int = 1; val l: Long = 1
        val f: Float = 1.0f; val d: Double = 1.0
        Engine.variables(mapOf(
            "bool" to true,
            "string" to "test",
            "b" to b, "s" to s,
            "i" to i, "l" to l,
            "f" to f, "d" to d
        ))
        Assert.assertEquals("truetest6.0", Engine.run("bool.toString() + string + " +
            "(b.toDouble() + s.toDouble() + i.toDouble() + l.toDouble() + f.toDouble() + d.toDouble()).toString()"
        ))
    }

    @Test
    fun functionTest() {
        fun functionCallback(string: String) = "Hello $string"
        Engine.variables(mapOf(
            "functionCallback" to ::functionCallback
        ))
        Assert.assertEquals("Hello world", Engine.run("""functionCallback("world")"""))
    }

}