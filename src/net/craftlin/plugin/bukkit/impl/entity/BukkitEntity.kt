package net.craftlin.plugin.bukkit.impl.entity

import net.craftlin.plugin.api.entity.Entity
import net.craftlin.plugin.api.world.Location
import net.craftlin.plugin.bukkit.impl.world.BukkitLocation
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity

abstract class BukkitEntity(private val origin: LivingEntity): Entity {
    override val uuid: String = origin.uniqueId.toString()
    override val location: Location
        get() = BukkitLocation(origin.location)
    override var customName: String
        get() = origin.customName
        set(value) { origin.customName = value }
    override var health: Int
        get() = origin.health.toInt()
        set(value) { origin.health = value.toDouble() }
    override var maxHealth: Int
        get() = origin.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue.toInt()
        set(value) { origin.getAttribute(Attribute.GENERIC_MAX_HEALTH).baseValue = value.toDouble() }
    override var isDead: Boolean
        get() = origin.isDead
        set(value) {}
    override var canPickupItems: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override var isCollidable: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun teleport(location: Location) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun teleport(entity: Entity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ignite(ticks: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun igniteTime(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun damage(amount: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}