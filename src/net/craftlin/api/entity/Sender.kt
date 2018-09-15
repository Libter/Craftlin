package net.craftlin.api.entity

/**
 * Represents a command sender
 */
interface Sender {
    /** Sends a message to the sender */
    fun message(message: String)

    /** Executes a command as sender */
    fun command(command: String)
}
