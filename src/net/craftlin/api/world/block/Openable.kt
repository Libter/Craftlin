package net.craftlin.api.world.block

interface Openable: Block {

    var opened: Boolean
    fun open() { opened = true }
    fun close() { opened = false }

}