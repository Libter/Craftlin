package net.craftlin.plugin.api.entity

import net.craftlin.plugin.api.world.Location

interface Entity {

    abstract val uuid: String
    abstract val location: Location
    abstract var customName: String
    abstract var health: Int
    abstract var maxHealth: Int
    abstract var isDead: Boolean
    abstract var canPickupItems: Boolean
    abstract var isCollidable: Boolean

    abstract fun teleport(location: Location)
    abstract fun teleport(entity: Entity)
    abstract fun ignite(ticks: Int)
    abstract fun igniteTime(): Int
    abstract fun damage(amount: Int)

}