package net.craftlin.api.entity.base

import net.craftlin.api.world.Location

interface Entity {

    val uuid: String
    var name: String
    val location: Location

    var health: Int
    var maxHealth: Int
    var dead: Boolean

    var canPickup: Boolean
    var canCollide: Boolean

    fun teleport(location: Location)
    fun ignite(ticks: Int)
    fun igniteTime(): Int
    fun damage(amount: Int)

}