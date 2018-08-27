package net.craftlin.api.util

import kotlin.math.max

class StringParser(val string: String): Iterable<Char> {
    data class PositionState(val char: Char, val position: Int, val leftPart: String, val rightPart: String)

    override fun iterator(): CharIterator = rightPart.iterator()

    var position = 0

    var positionAfterLastAction = 0

    val current inline get() = try { string[position] } catch (e: StringIndexOutOfBoundsException) { null }

    val rightPart inline get() = string.substring(position)

    fun reset(hard: Boolean = false) : StringParser {
        if (hard) position = 0
        positionAfterLastAction = 0
        return this
    }

    fun readTextUntil(str: String, includeStr: Boolean = false) : String? {
        val pos = nextPos(str)
        return if (pos == null) null else if (includeStr) rightPart.substring(0, pos) + str else rightPart.substring(0, pos)
    }

    /**
     * Reads text until the specified [char]
     *
     * @param canBeEscaped Can the specified char be escaped with a backslash?
     */
    fun readTextUntil(char: Char, canBeEscaped: Boolean = false) : String? {
        val splitted = rightPart.split(char).dropLast(1).toMutableList()
        if (splitted.isEmpty()) {
            return null
        } else {
            if (canBeEscaped) {
                for (i in 0 until splitted.size) {
                    val match = Regex("""[\\]+$""").matchEntire(splitted[i])?.value
                    when {
                        (match?.length ?: 2) % 2 == 1 -> splitted[i] = splitted[i].dropLast(match!!.length)
                        match != null -> splitted[i] = splitted[i].dropLast(match.length / 2)
                        else -> {
                            splitted.subList(0, i).joinToString(char.toString()).apply {
                                positionAfterLastAction = position + length
                                return this
                            }
                        }
                    }
                }
                return null
            } else {
                positionAfterLastAction = position + splitted.first().length
                return splitted.first()
            }
        }
    }

    fun next() : StringParser {
        if (endReached()) {
            return this
        }
        if (positionAfterLastAction > position) {
            position = positionAfterLastAction
        } else {
            position++
        }
        position = max(position, positionAfterLastAction)
        return this
    }

    fun next(str: String) : StringParser? {
        nextPos(str)?.apply {
            skip(this + str.length)
            return this@StringParser
        }
        return null
    }

    fun nextPos(string: String, relative: Boolean = true) : Int? {
        val pos = rightPart.indexOf(string)
        return if (pos != -1) { if(relative) pos else pos + position } else null
    }

    inline fun skip(steps: Int) {
        position += steps
    }

    inline fun nextPos(any: Any, relative: Boolean = true) : Int? = nextPos(any.toString(), relative)

    inline fun endReached() = position == string.length

    fun skipSpaces() {
        rightPart.forEach {
            if (it == ' ') position++ else return
        }
    }

    inline fun startsWith(text: String) = rightPart.startsWith(text)

    inline fun between(start: Int = position, end: Int): StringParser = StringParser(string.substring(start, end))

    inline fun textBetween(start: String, end: String): String? {
        return StringParser(this.string.substring((nextPos(start, false) ?: return null) + start.length)).readTextUntil(end)
    }
}