package net.craftlin.api.world

data class Sound(
    var type: String,
    var volume: Double = 1.0,
    var pitch: Double = 1.0
)