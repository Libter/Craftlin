package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Chicken
import net.craftlin.api.entity.animal.Cow
import net.craftlin.api.entity.animal.MushroomCow
import net.craftlin.api.entity.animal.PolarBear
import net.craftlin.api.entity.animal.Turtle
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity

class BukkitChicken(origin: org.bukkit.entity.Chicken): BukkitGrowingEntity(origin), Chicken

class BukkitCow(origin: org.bukkit.entity.Cow): BukkitGrowingEntity(origin), Cow

class BukkitMushroomCow(origin: org.bukkit.entity.MushroomCow): BukkitGrowingEntity(origin), MushroomCow

class BukkitPolarBear(origin: org.bukkit.entity.PolarBear): BukkitGrowingEntity(origin), PolarBear

class BukkitTurtle(origin: org.bukkit.entity.Turtle): BukkitGrowingEntity(origin), Turtle