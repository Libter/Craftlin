package net.craftlin.api.misc

import java.util.concurrent.ThreadLocalRandom

private val origin get() = ThreadLocalRandom.current()

fun chance(percent: Long) = chance(percent.toDouble())
fun chance(percent: Double) = percent >= origin.nextDouble() * 100.0

fun random(range: IntRange) = random(LongRange(range.start.toLong(), range.endInclusive.toLong()))
fun random(range: LongRange) = origin.nextLong(range.start, range.endInclusive + 1)