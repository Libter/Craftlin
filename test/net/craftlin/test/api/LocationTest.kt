package net.craftlin.test.api

import com.nhaarman.mockitokotlin2.mock
import net.craftlin.api.world.Location
import net.craftlin.api.world.World
import org.junit.Assert.assertEquals
import org.junit.Test

class LocationTest {

    private val delta = 0.001
    private val world: World = mock()
    private val loc1 = Location(world, -1.5, 2.0, 3.7)
    private val loc2 = Location(world, 2.7, -5.0, 1.8)

    @Test
    fun testDistance2D() {
        assertEquals(4.609772, loc1.distance2D(loc2), delta)
        assertEquals(4.609772, loc2.distance2D(loc1), delta)
    }

    @Test
    fun testDistance3D() {
        assertEquals(8.381527, loc1.distance3D(loc2), delta)
        assertEquals(8.381527, loc2.distance3D(loc1), delta)
    }

}