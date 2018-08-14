package net.craftlin.plugin.bukkit.extension

import org.bukkit.ChatColor

fun String.color(): String = ChatColor.translateAlternateColorCodes('&', this)