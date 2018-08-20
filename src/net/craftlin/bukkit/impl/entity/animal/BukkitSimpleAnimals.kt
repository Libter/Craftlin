package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Chicken
import net.craftlin.api.entity.animal.Cow
import net.craftlin.api.entity.animal.MushroomCow
import net.craftlin.api.entity.animal.PolarBear
import net.craftlin.api.entity.animal.Turtle
import net.craftlin.bukkit.impl.entity.base.BukkitGrowingEntity

class BukkitChicken(origin: org.bukkit.entity.Chicken): BukkitGrowingEntity(origin), Chicken

class BukkitCow(origin: org.bukkit.entity.Cow): BukkitGrowingEntity(origin), Cow

class MushroomCow(origin: org.bukkit.entity.MushroomCow): BukkitGrowingEntity(origin), MushroomCow

class PolarBear(origin: org.bukkit.entity.PolarBear): BukkitGrowingEntity(origin), PolarBear

class Turtle(origin: org.bukkit.entity.Turtle): BukkitGrowingEntity(origin), Turtle