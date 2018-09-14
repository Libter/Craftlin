package net.craftlin.bukkit.impl.entity.base

import net.craftlin.api.entity.base.Entity
import net.craftlin.bukkit.impl.entity.BukkitDroppedItem
import net.craftlin.bukkit.impl.entity.animal.BukkitBat
import net.craftlin.bukkit.impl.entity.animal.BukkitChicken
import net.craftlin.bukkit.impl.entity.animal.BukkitCow
import net.craftlin.bukkit.impl.entity.animal.BukkitMushroomCow
import net.craftlin.bukkit.impl.entity.animal.BukkitOcelot
import net.craftlin.bukkit.impl.entity.animal.BukkitParrot
import net.craftlin.bukkit.impl.entity.animal.BukkitPig
import net.craftlin.bukkit.impl.entity.animal.BukkitPolarBear
import net.craftlin.bukkit.impl.entity.animal.BukkitRabbit
import net.craftlin.bukkit.impl.entity.animal.BukkitSheep
import net.craftlin.bukkit.impl.entity.animal.BukkitTurtle
import net.craftlin.bukkit.impl.entity.animal.BukkitWolf
import net.craftlin.bukkit.impl.value.BukkitEntityType
import net.craftlin.bukkit.impl.world.BukkitLocation
import org.bukkit.Location

open class BukkitEntity protected constructor(protected val entity: org.bukkit.entity.Entity): Entity {

    companion object {
        fun create(entity: org.bukkit.entity.Entity) = when (entity) {
            is org.bukkit.entity.Bat -> BukkitBat(entity)
            is org.bukkit.entity.Ocelot -> BukkitOcelot(entity)
            is org.bukkit.entity.Parrot -> BukkitParrot(entity)
            is org.bukkit.entity.Pig -> BukkitPig(entity)
            is org.bukkit.entity.Rabbit -> BukkitRabbit(entity)
            is org.bukkit.entity.Sheep -> BukkitSheep(entity)
            is org.bukkit.entity.Chicken -> BukkitChicken(entity)
            is org.bukkit.entity.Cow -> BukkitCow(entity)
            is org.bukkit.entity.MushroomCow -> BukkitMushroomCow(entity)
            is org.bukkit.entity.PolarBear -> BukkitPolarBear(entity)
            is org.bukkit.entity.Turtle -> BukkitTurtle(entity)
            is org.bukkit.entity.Wolf -> BukkitWolf(entity)
            is org.bukkit.entity.Item -> BukkitDroppedItem(entity)
            else -> BukkitEntity(entity)
        }
    }

    private var originLocation: Location
        get() = entity.location
        set(value) { entity.teleport(value) }

    override val uuid: String = entity.uniqueId.toString()
    override val type: String = BukkitEntityType.Converter(entity.type)
    override var name: String
        get() = entity.customName
        set(value) { entity.customName = value }
    override var location by BukkitLocation.Delegate(::originLocation)
}