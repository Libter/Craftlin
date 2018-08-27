package net.craftlin.test.util

import org.junit.Assert.fail
import kotlin.reflect.KClass

fun assertThrows(clazz: KClass<out Throwable>, block: () -> Unit) {
    try {
        block()
        fail("Expected throwable: ${clazz.simpleName}")
    } catch (throwable: Throwable) {
        if (!clazz.isInstance(throwable)) {
            fail("Unexpected throwable: ${throwable::class.simpleName}")
        }
    }
}