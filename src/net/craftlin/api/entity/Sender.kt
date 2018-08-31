package net.craftlin.api.entity

/**
 * Represents a command sender
 */
interface Sender {
    /** Sends a message to a sender */
    fun message(message: String)
}
