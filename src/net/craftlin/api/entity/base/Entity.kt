package net.craftlin.api.entity.base

import net.craftlin.api.world.Location

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
    fun teleport(entity: Entity) = teleport(entity.location)
    fun ignite(ticks: Int)
    fun igniteTime(): Int
    fun damage(amount: Int)

}