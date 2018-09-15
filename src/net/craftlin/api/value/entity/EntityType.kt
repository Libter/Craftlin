package net.craftlin.api.value.entity

import net.craftlin.api.entity.DroppedItem
import net.craftlin.api.entity.animal.Bat
import net.craftlin.api.entity.animal.Chicken
import net.craftlin.api.entity.animal.Cow
import net.craftlin.api.entity.animal.MushroomCow
import net.craftlin.api.entity.animal.Ocelot
import net.craftlin.api.entity.animal.Parrot
import net.craftlin.api.entity.animal.Pig
import net.craftlin.api.entity.animal.PolarBear
import net.craftlin.api.entity.animal.Rabbit
import net.craftlin.api.entity.animal.Sheep
import net.craftlin.api.entity.animal.Turtle
import net.craftlin.api.entity.animal.Wolf
import net.craftlin.api.entity.base.Entity
import kotlin.reflect.KClass

enum class EntityType {
    AREA_EFFECT_CLOUD,
    ARMOR_STAND,
    ARROW,
    BAT,
    BLAZE,
    BOAT,
    CAVE_SPIDER,
    CHICKEN,
    COD,
    COMPLEX_PART,
    COW,
    CREEPER,
    DOLPHIN,
    DONKEY,
    DRAGON_FIREBALL,
    ITEM,
    DROWNED,
    EGG,
    ELDER_GUARDIAN,
    ENDER_CRYSTAL,
    ENDER_DRAGON,
    ENDER_PEARL,
    ENDER_SIGNAL,
    ENDERMAN,
    ENDERMITE,
    EVOKER,
    EVOKER_FANGS,
    EXPERIENCE_ORB,
    FALLING_BLOCK,
    FIREBALL,
    FIREWORK,
    FISHING_HOOK,
    GHAST,
    GIANT,
    GUARDIAN,
    HORSE,
    HUSK,
    ILLUSIONER,
    IRON_GOLEM,
    ITEM_FRAME,
    LEASH_HITCH,
    LIGHTNING,
    LINGERING_POTION,
    LLAMA,
    LLAMA_SPIT,
    MAGMA_CUBE,
    MINECART,
    MINECART_CHEST,
    MINECART_COMMAND,
    MINECART_FURNACE,
    MINECART_HOPPER,
    MINECART_MOB_SPAWNER,
    MINECART_TNT,
    MULE,
    MUSHROOM_COW,
    OCELOT,
    PAINTING,
    PARROT,
    PHANTOM,
    PIG,
    PIG_ZOMBIE,
    PLAYER,
    POLAR_BEAR,
    PRIMED_TNT,
    PUFFERFISH,
    RABBIT,
    SALMON,
    SHEEP,
    SHULKER,
    SHULKER_BULLET,
    SILVERFISH,
    SKELETON,
    SKELETON_HORSE,
    SLIME,
    SMALL_FIREBALL,
    SNOWBALL,
    SNOWMAN,
    SPECTRAL_ARROW,
    SPIDER,
    SPLASH_POTION,
    SQUID,
    STRAY,
    THROWN_EXP_BOTTLE,
    TIPPED_ARROW,
    TRIDENT,
    TROPICAL_FISH,
    TURTLE,
    VEX,
    VILLAGER,
    VINDICATOR,
    WEATHER,
    WITCH,
    WITHER,
    WITHER_SKELETON,
    WITHER_SKULL,
    WOLF,
    ZOMBIE,
    ZOMBIE_HORSE,
    ZOMBIE_VILLAGER;

    companion object {
        private val types = mapOf(
            Bat::class to EntityType.BAT,
            Ocelot::class to EntityType.OCELOT,
            Parrot::class to EntityType.PARROT,
            Pig::class to EntityType.PIG,
            Rabbit::class to EntityType.RABBIT,
            Sheep::class to EntityType.SHEEP,
            Wolf::class to EntityType.WOLF,
            Chicken::class to EntityType.CHICKEN,
            Cow::class to EntityType.COW,
            MushroomCow::class to EntityType.MUSHROOM_COW,
            PolarBear::class to EntityType.POLAR_BEAR,
            Turtle::class to EntityType.TURTLE,
            DroppedItem::class to EntityType.ITEM
        )

        fun fromClass(type: KClass<out Entity>) = types[type] ?: throw NotImplementedError()
    }


}