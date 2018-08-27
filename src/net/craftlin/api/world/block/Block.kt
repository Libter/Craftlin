package net.craftlin.api.world.block

import net.craftlin.api.world.Location

interface Block {
    var type: String
    val location: Location
}