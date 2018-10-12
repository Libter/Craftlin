package net.craftlin.bukkit.impl.entity

import net.craftlin.api.entity.Lightning
import net.craftlin.bukkit.impl.entity.base.BukkitEntity
import org.bukkit.entity.LightningStrike

class BukkitLightning(origin: LightningStrike): BukkitEntity(origin), Lightning