package net.craftlin.test

import net.craftlin.api.util.value.BiEnumValue
import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.LoginResult
import net.craftlin.api.value.WorldType
import org.junit.Assert.assertEquals
import org.junit.Test

class SimpleEnumTest {

    private enum class ServerWorldType {
        DAY, NIGHT, HELL
    }

    private object TestWorldType: EnumValue<WorldType, ServerWorldType>(WorldType::class) {
        override fun convert(api: WorldType): ServerWorldType {
            return when(api) {
                WorldType.NORMAL -> ServerWorldType.DAY
                WorldType.NETHER -> ServerWorldType.HELL
                WorldType.END -> ServerWorldType.NIGHT
            }
        }
    }

    private class ServerWorld(var type: ServerWorldType)

    private class TestServerWorld(private val origin: ServerWorld) {
        private var originType: ServerWorldType
            get() = origin.type
            set(value) { origin.type = value }

        var type by TestWorldType.Delegate(::originType)
    }

    @Test
    fun enumValueTest() {
        val serverWorld = ServerWorld(ServerWorldType.DAY)
        val world = TestServerWorld(serverWorld)
        assertEquals("normal", world.type)

        serverWorld.type = ServerWorldType.NIGHT
        assertEquals("end", world.type)

        world.type = "nether"
        assertEquals(ServerWorldType.HELL, serverWorld.type)
    }

    private enum class ServerLoginResult {
        YES, NO, MAYBE
    }

    private object TestLoginResult: BiEnumValue<LoginResult, ServerLoginResult>(LoginResult::class) {
        override fun toImpl(api: LoginResult): ServerLoginResult {
            return when(api) {
                LoginResult.ALLOW -> ServerLoginResult.YES
                LoginResult.DISALLOW -> ServerLoginResult.NO
            }
        }

        override fun toApi(impl: ServerLoginResult): LoginResult {
            return when(impl) {
                SimpleEnumTest.ServerLoginResult.YES -> LoginResult.ALLOW
                else -> LoginResult.DISALLOW
            }
        }
    }

    private class ServerLoginEvent(var result: ServerLoginResult)

    private class TestLoginEvent(private val origin: ServerLoginEvent) {
        private var originResult: ServerLoginResult
            get() = origin.result
            set(value) { origin.result = value }

        var result by TestLoginResult.Delegate(::originResult)
    }

    @Test
    fun biEnumValueTest() {
        val serverEvent = ServerLoginEvent(ServerLoginResult.MAYBE)
        val event = TestLoginEvent(serverEvent)
        assertEquals("disallow", event.result)

        serverEvent.result = ServerLoginResult.YES
        assertEquals("allow", event.result)

        event.result = "disallow"
        assertEquals(ServerLoginResult.NO, serverEvent.result)
    }

}