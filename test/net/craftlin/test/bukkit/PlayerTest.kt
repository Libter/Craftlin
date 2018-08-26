package net.craftlin.test.bukkit

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import net.craftlin.bukkit.impl.entity.BukkitOfflinePlayer
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.UUID

class PlayerTest {

    private val uuid = UUID.randomUUID()
    private val origin: Player = mock {
        var mode = GameMode.SURVIVAL
        on { name } doReturn "tester"
        on { uniqueId } doReturn uuid
        on { isOnline } doReturn true
        on { gameMode } doAnswer { mode }
        on { gameMode = any() } doAnswer { mode = it.getArgument<GameMode>(0); Unit }
    }
    private val player = BukkitPlayer(origin)
    private val oPlayer = BukkitOfflinePlayer(origin)

    @Test
    fun testName() {
        assertEquals("tester", player.name)
        player.name = "x" //player name should be immutable
        assertEquals("tester", player.name)
    }

    @Test
    fun testGameMode() {
        assertEquals("survival", player.gamemode)
        player.gamemode = "creative"
        assertEquals(GameMode.CREATIVE, origin.gameMode)
        origin.gameMode = GameMode.SPECTATOR
        assertEquals("spectator", player.gamemode)
    }

    @Test
    fun testVariables() {
        assertEquals(uuid.toString(), player.uuid)
        assertEquals(true, player.online)

        assertEquals("tester", oPlayer.name)
        assertEquals(uuid.toString(), oPlayer.uuid)
        assertEquals(true, oPlayer.online)
    }

    @Test
    fun testFunctions() {
        player.message("test")
        verify(origin).sendMessage("test")

        player.kick("test")
        verify(origin).kickPlayer("test")
    }

}