package net.craftlin.api.world

interface Location {

    var x: Double
    var y: Double
    var z: Double

    var pitch: Double
    var yaw: Double

    var world: World

    var blockX
        get() = x.toInt()
        set(value) { x = value.toDouble() }
    var blockY
        get() = y.toInt()
        set(value) { y = value.toDouble() }
    var blockZ
        get() = z.toInt()
        set(value) { z = value.toDouble() }

}