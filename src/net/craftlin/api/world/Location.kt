package net.craftlin.api.world

/**
 * Represents the Minecraft location.
 */
interface Location {

    var x: Double
    var y: Double
    var z: Double

    var pitch: Double
    var yaw: Double

    var world: World

    /** [x] as an integer (not double) */
    var blockX
        get() = x.toInt()
        set(value) { x = value.toDouble() }
    /** [y] as an integer (not double) */
    var blockY
        get() = y.toInt()
        set(value) { y = value.toDouble() }
    /** [z] as an integer (not double) */
    var blockZ
        get() = z.toInt()
        set(value) { z = value.toDouble() }

}