package net.craftlin.api.world

/**
 * Represents a Minecraft location.
 */
class Location(
    var world: World,
    var x: Double,
    var y: Double,
    var z: Double,
    var pitch: Double = 0.0,
    var yaw: Double = 0.0
) {

    /** [x] as an integer */
    var blockX
        get() = toBlock(x)
        set(value) { x = value.toDouble() }
    /** [y] as an integer */
    var blockY
        get() = toBlock(y)
        set(value) { y = value.toDouble() }
    /** [z] as an integer */
    var blockZ
        get() = toBlock(z)
        set(value) { z = value.toDouble() }

    private fun toBlock(double: Double): Long {
        return double.toLong() - double.toRawBits().ushr(63)
    }

    /** Calculates a distance between ([x], [z]) and ([other.x], [other.z]] */
    fun distance2D(other: Location): Double {
        val xDiff = x - other.x
        val zDiff = z - other.z
        return Math.sqrt(
            (xDiff * xDiff) + (zDiff * zDiff)
        )
    }

    /** Calculates a distance between ([x], [y], [z]) and ([other.x], [other.y], [other.z]] */
    fun distance3D(other: Location): Double {
        val xDiff = x - other.x
        val yDiff = y - other.y
        val zDiff = z - other.z
        return Math.sqrt(
            (xDiff * xDiff) + (yDiff * yDiff) + (zDiff * zDiff)
        )
    }

}