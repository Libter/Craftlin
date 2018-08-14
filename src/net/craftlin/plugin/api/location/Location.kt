package net.craftlin.plugin.api.location

abstract class Location {

    abstract val x: Double
    abstract val y: Double
    abstract val z: Double
    abstract val blockX: Int
    abstract val blockY: Int
    abstract val blockZ: Int
    abstract val pitch: Float
    abstract val yaw: Float
    abstract val world: World

}