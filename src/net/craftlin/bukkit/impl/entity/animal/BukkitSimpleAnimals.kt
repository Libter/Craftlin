package net.craftlin.bukkit.impl.entity.animal

import net.craftlin.api.entity.animal.Chicken
import net.craftlin.api.entity.animal.Cow
import net.craftlin.api.entity.animal.MushroomCow
import net.craftlin.api.entity.animal.PolarBear
import net.craftlin.api.entity.animal.Turtle
import net.craftlin.bukkit.impl.entity.base.BukkitAgeableEntity

class BukkitChicken(origin: org.bukkit.entity.Chicken): BukkitAgeableEntity(origin), Chicken

class BukkitCow(origin: org.bukkit.entity.Cow): BukkitAgeableEntity(origin), Cow

class MushroomCow(origin: org.bukkit.entity.MushroomCow): BukkitAgeableEntity(origin), MushroomCow

class PolarBear(origin: org.bukkit.entity.PolarBear): BukkitAgeableEntity(origin), PolarBear

class Turtle(origin: org.bukkit.entity.Turtle): BukkitAgeableEntity(origin), Turtle