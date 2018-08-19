package net.craftlin.api.entity

interface OfflinePlayer {
    val name: String
    val uuid: String
    val online: Boolean
}