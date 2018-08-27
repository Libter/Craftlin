package net.craftlin.api.command

import net.craftlin.api.util.StringParser
import java.math.BigDecimal
import java.math.BigInteger
import java.security.InvalidParameterException

// TODO: unit tests
// TODO: optional blocks
// TODO: some way to get Server instance inside API (needed for CommandArguments.Argument.Type.Player and OfflinePlayer)
class CommandArguments constructor(val userInput: String, val pattern: List<Argument> = emptyList()) {
    class Argument(val name: String, val type: Type, val isOptional: Boolean = false) {
        enum class Type(val codeName: String) {
            TEXT("text"),
            NUMBER("number"),
            DECIMAL("decimal");
            //PLAYER("player"),
            //OFFLINEPLAYER("offlinePlayer");

            companion object {
                fun findByCodeName(codeName: String) : Type? = Type::class.java.enumConstants.find { it.codeName == codeName}
            }
        }
    }

    class InvalidPatternException(message: String? = null, val pos: Int): Exception(message)

    companion object {
        fun parseArgumentsPattern(pattern: String) : List<Argument> {
            if (pattern.isBlank()) return listOf()
            val parser = StringParser(pattern.trim())
            val args = mutableListOf<Argument>()
            var anyOptional = false
            while (!parser.endReached()) {
                val startChar = parser.current
                val endChar: Char
                when (parser.current) {
                    '[' -> {
                        endChar = ']'
                        anyOptional = true
                    }
                    '<' -> {
                        endChar = '>'
                        if (anyOptional) throw InvalidPatternException("Unexpected chevron; required arguments after optional arguments are not allowed", parser.position)
                    }
                    else -> throw InvalidPatternException("Unexpected character: $startChar", parser.position)
                }
                parser.next()
                val contents = parser.readTextUntil(")") ?: throw InvalidPatternException("Argument expression can't be left open", parser.position)
                if (contents.isBlank()) throw InvalidPatternException("Argument expression cannot be empty", parser.position)
                val contentParser = StringParser(contents)
                val name = contentParser.readTextUntil(":")?.trim() ?: throw InvalidPatternException("Unexpected '$endChar', type separator not found", parser.position + contents.length)
                val type = Argument.Type.findByCodeName(contentParser.next().rightPart) ?: throw InvalidPatternException("""Invalid type: "${contentParser.rightPart}" """, parser.position + contentParser.position)
                parser.next()
                parser.skipSpaces()
                args.add(CommandArguments.Argument(name, type, anyOptional))
            }
            return args
        }
    }

    val argumentsFromPattern: Map<String, Pair<Argument.Type, Any?>>
    val isValid: Boolean
    val invalidArgs: List<String>

    operator fun get(key: String): Any? = (argumentsFromPattern[key] ?: throw InvalidParameterException("Parameter `$key` is not specified in pattern")).second

    inline fun text(key: String): String?                 = this[key] as String?
    inline fun number(key: String): BigInteger?           = this[key] as BigInteger?
    inline fun decimal(key: String): BigDecimal?          = this[key] as BigDecimal?
    //inline fun player(key: String): Player?               = this[key] as Player?
    //inline fun offlinePlayer(key: String): OfflinePlayer? = this[key] as OfflinePlayer?

    fun exists(key: String) : Boolean = argumentsFromPattern.containsKey(key)

    fun isset(key: String) : Boolean = (argumentsFromPattern[key] ?: throw InvalidParameterException("Parameter `$key` is not specified in pattern")).second != null

    fun isInvalid(key: String) : Boolean = invalidArgs.contains(key)

    init {
        if (pattern.isEmpty()) {
            argumentsFromPattern = mapOf()
            invalidArgs = listOf()
            isValid = true
        } else {
            val input = userInput.trim().replace(Regex(" {2,}"), " ").split(" ")
            val args = mutableMapOf<String, Pair<Argument.Type, Any?>>()
            var isValid = true
            val invalidKeys = mutableListOf<String>()
            for (i in 0 until pattern.size) {
                if (input.size <= i) {
                    args[pattern[i].name] = pattern[i].type to null
                    if (!pattern[i].isOptional) {
                        isValid = false
                    }
                    continue
                }
                args[pattern[i].name] = pattern[i].type to when (pattern[i].type) {
                    CommandArguments.Argument.Type.TEXT -> input[i]
                    CommandArguments.Argument.Type.NUMBER -> try {
                        BigInteger(input[i])
                    } catch (e: NumberFormatException) {
                        invalidKeys.add(pattern[i].name)
                        null
                    }
                    CommandArguments.Argument.Type.DECIMAL -> try {
                        BigDecimal(input[i])
                    } catch (e: NumberFormatException) {
                        invalidKeys.add(pattern[i].name)
                        null
                    }
                    //CommandArguments.Argument.Type.PLAYER -> ...
                    //CommandArguments.Argument.Type.OFFLINEPLAYER -> ...
                }
            }
            this.argumentsFromPattern = args
            this.invalidArgs = invalidKeys
            this.isValid = isValid
        }
    }
}