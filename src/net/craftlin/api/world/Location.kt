package net.craftlin.api.world

interface Location {

    val x: Double
    val y: Double
    val z: Double
    val pitch: Float
    val yaw: Float
    val world: World

    val blockX get() = x.toInt()
    val blockY get() = y.toInt()
    val blockZ get() = z.toInt()

}