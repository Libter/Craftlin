package net.craftlin.api.world.block

/**
 * Represents an openable block (like [Door])
 */
interface Openable: Block {

    var opened: Boolean
    fun open() { opened = true }
    fun close() { opened = false }

}