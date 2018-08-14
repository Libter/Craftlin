package net.craftlin.plugin.api.world

abstract class Location {

    abstract val x: Double
    abstract val y: Double
    abstract val z: Double
    abstract val pitch: Float
    abstract val yaw: Float
    abstract val world: World

    val blockX by lazy { x.toInt() }
    val blockY by lazy { y.toInt() }
    val blockZ by lazy { z.toInt() }

}