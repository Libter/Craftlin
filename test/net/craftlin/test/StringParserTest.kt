package net.craftlin.test

import net.craftlin.api.util.StringParser
import org.junit.Assert
import org.junit.Test

class StringParserTest {
    @Test
    fun readTextUntilTest() {
        with(StringParser("<test>abc</test>")) {
            assert(next("<test>")!!.readTextUntil("</test>") == "abc")
        }
    }

    @Test
    fun readTextBetweenTest() {
        with(StringParser("<test>abc</test>")) {
            assert(textBetween("<test>", "</test>") == "abc")
        }
    }

    // TODO: more tests
}