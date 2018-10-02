package net.craftlin.bukkit.impl.world

import net.craftlin.api.entity.DroppedItem
import net.craftlin.api.entity.Lightning
import net.craftlin.api.entity.base.Entity
import net.craftlin.api.inventory.Item
import net.craftlin.api.value.entity.EntityType
import net.craftlin.api.world.Location
import net.craftlin.api.world.World
import net.craftlin.bukkit.impl.entity.BukkitDroppedItem
import net.craftlin.bukkit.impl.entity.BukkitPlayer
import net.craftlin.bukkit.impl.entity.base.BukkitEntity
import net.craftlin.bukkit.impl.inventory.BukkitItem
import net.craftlin.bukkit.impl.value.BukkitEntityType
import net.craftlin.bukkit.impl.value.BukkitWorldDifficulty
import net.craftlin.bukkit.impl.value.BukkitWorldType
import kotlin.reflect.KClass
import kotlin.reflect.full.safeCast

class BukkitWorld(private val origin: org.bukkit.World): World {
    override val type = BukkitWorldType.Converter(origin.environment)
    override val difficulty = BukkitWorldDifficulty.Converter(origin.difficulty)
    override val name: String = origin.name
    override val players get() = origin.players.map { BukkitPlayer(it) }
    override val seed = origin.seed.toString()

    override fun blockAt(x: Long, y: Long, z: Long) = BukkitBlock(origin.getBlockAt(x.toInt(), y.toInt(), z.toInt()))

    override fun <T: Entity> spawn(type: KClass<T>, location: Location): T {
        //TODO: if type == Item::class it should use code from drop, then we can remove drop function
        val iLocation = BukkitLocation.toImpl(location)
        val entity = when (type) {
            Lightning::class -> {
                //TODO: strikeLightningEffect... or create it in separate effects class
                origin.strikeLightning(iLocation)
            }
            else -> {
                val originType = BukkitEntityType.Converter(EntityType.fromClass(type))
                origin.spawnEntity(iLocation, originType)
            }
        }
        return type.safeCast(BukkitEntity.create(entity)) ?: throw NotImplementedError()
    }

    override fun drop(item: Item, location: Location): DroppedItem {
        return BukkitDroppedItem(origin.dropItemNaturally(
            BukkitLocation.toImpl(location),
            BukkitItem.toImpl(item)
        ))
    }
}