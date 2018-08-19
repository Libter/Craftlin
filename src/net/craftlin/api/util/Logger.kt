package net.craftlin.api.util

import java.text.DecimalFormat

object Logger {

    private var start: Long = 0
    private val seconds = DecimalFormat("0.000")

    fun reset() {
        start = System.currentTimeMillis()
    }

    fun log(message: String) {
        val diff = seconds.format(Math.min((System.currentTimeMillis() - start) / 1000.0, 999.0))
        println("[$diff] $message")
    }

}