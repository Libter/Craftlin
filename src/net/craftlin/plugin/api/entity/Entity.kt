package net.craftlin.plugin.api.entity

import net.craftlin.plugin.api.world.Location

interface Entity {

    val uuid: String
    val location: Location
    var customName: String
    var health: Int
    var maxHealth: Int
    var isDead: Boolean
    var canPickupItems: Boolean
    var isCollidable: Boolean

    fun teleport(location: Location)
    fun teleport(entity: Entity)
    fun ignite(ticks: Int)
    fun igniteTime(): Int
    fun damage(amount: Int)

}