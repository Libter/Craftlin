package net.craftlin.test.bukkit

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import net.craftlin.api.value.world.BlockType
import net.craftlin.bukkit.impl.world.BukkitBlock
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Test
import java.util.UUID

class BlockTest {

    private val uuid = UUID.randomUUID()
    private val world: World = mock {
        on { name } doReturn "world"
        on { uid } doReturn uuid
        on { environment } doReturn World.Environment.NORMAL
    }
    private val location: Location = mock {
        on { x } doReturn -1.0
        on { y } doReturn +1.0
        on { z } doReturn 0.0
        on { pitch } doReturn 0.0f
        on { yaw } doReturn 0.0f
        on { world } doReturn world
    }
    private val origin: Block = mock {
        var material = Material.AIR
        on { location } doReturn location
        on { type } doAnswer { material }
        on { type = any() } doAnswer { material = it.getArgument<Material>(0); Unit }
    }
    private val block = BukkitBlock(origin)

    @Test
    fun testType() {
        BlockType.values().forEach {
            val material = origin.type
            val typeName = it.name.toLowerCase().replace('_', ' ')
            block.type = typeName
            assertEquals(block.type, typeName)
            assertNotSame(material, origin.type)
        }
    }

}