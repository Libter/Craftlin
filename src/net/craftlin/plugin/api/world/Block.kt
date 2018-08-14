package net.craftlin.plugin.api.world

abstract class Block {
    abstract var type: String
    abstract val location: Location
}