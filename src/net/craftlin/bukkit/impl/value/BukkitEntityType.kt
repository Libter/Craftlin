package net.craftlin.bukkit.impl.value

import net.craftlin.api.util.value.EnumValue
import net.craftlin.api.value.entity.EntityType

object BukkitEntityType: EnumValue<EntityType, org.bukkit.entity.EntityType>(EntityType::class) {
    override fun Converter(api: EntityType): org.bukkit.entity.EntityType {
        return when (api) {
            EntityType.AREA_EFFECT_CLOUD -> org.bukkit.entity.EntityType.AREA_EFFECT_CLOUD
            EntityType.ARMOR_STAND -> org.bukkit.entity.EntityType.ARMOR_STAND
            EntityType.ARROW -> org.bukkit.entity.EntityType.ARROW
            EntityType.BAT -> org.bukkit.entity.EntityType.BAT
            EntityType.BLAZE -> org.bukkit.entity.EntityType.BLAZE
            EntityType.BOAT -> org.bukkit.entity.EntityType.BOAT
            EntityType.CAVE_SPIDER -> org.bukkit.entity.EntityType.CAVE_SPIDER
            EntityType.CHICKEN -> org.bukkit.entity.EntityType.CHICKEN
            EntityType.COD -> org.bukkit.entity.EntityType.COD
            EntityType.COMPLEX_PART -> org.bukkit.entity.EntityType.COMPLEX_PART
            EntityType.COW -> org.bukkit.entity.EntityType.COW
            EntityType.CREEPER -> org.bukkit.entity.EntityType.CREEPER
            EntityType.DOLPHIN -> org.bukkit.entity.EntityType.DOLPHIN
            EntityType.DONKEY -> org.bukkit.entity.EntityType.DONKEY
            EntityType.DRAGON_FIREBALL -> org.bukkit.entity.EntityType.DRAGON_FIREBALL
            EntityType.DROPPED_ITEM -> org.bukkit.entity.EntityType.DROPPED_ITEM
            EntityType.DROWNED -> org.bukkit.entity.EntityType.DROWNED
            EntityType.EGG -> org.bukkit.entity.EntityType.EGG
            EntityType.ELDER_GUARDIAN -> org.bukkit.entity.EntityType.ELDER_GUARDIAN
            EntityType.ENDER_CRYSTAL -> org.bukkit.entity.EntityType.ENDER_CRYSTAL
            EntityType.ENDER_DRAGON -> org.bukkit.entity.EntityType.ENDER_DRAGON
            EntityType.ENDER_PEARL -> org.bukkit.entity.EntityType.ENDER_PEARL
            EntityType.ENDER_SIGNAL -> org.bukkit.entity.EntityType.ENDER_SIGNAL
            EntityType.ENDERMAN -> org.bukkit.entity.EntityType.ENDERMAN
            EntityType.ENDERMITE -> org.bukkit.entity.EntityType.ENDERMITE
            EntityType.EVOKER -> org.bukkit.entity.EntityType.EVOKER
            EntityType.EVOKER_FANGS -> org.bukkit.entity.EntityType.EVOKER_FANGS
            EntityType.EXPERIENCE_ORB -> org.bukkit.entity.EntityType.EXPERIENCE_ORB
            EntityType.FALLING_BLOCK -> org.bukkit.entity.EntityType.FALLING_BLOCK
            EntityType.FIREBALL -> org.bukkit.entity.EntityType.FIREBALL
            EntityType.FIREWORK -> org.bukkit.entity.EntityType.FIREWORK
            EntityType.FISHING_HOOK -> org.bukkit.entity.EntityType.FISHING_HOOK
            EntityType.GHAST -> org.bukkit.entity.EntityType.GHAST
            EntityType.GIANT -> org.bukkit.entity.EntityType.GIANT
            EntityType.GUARDIAN -> org.bukkit.entity.EntityType.GUARDIAN
            EntityType.HORSE -> org.bukkit.entity.EntityType.HORSE
            EntityType.HUSK -> org.bukkit.entity.EntityType.HUSK
            EntityType.ILLUSIONER -> org.bukkit.entity.EntityType.ILLUSIONER
            EntityType.IRON_GOLEM -> org.bukkit.entity.EntityType.IRON_GOLEM
            EntityType.ITEM_FRAME -> org.bukkit.entity.EntityType.ITEM_FRAME
            EntityType.LEASH_HITCH -> org.bukkit.entity.EntityType.LEASH_HITCH
            EntityType.LIGHTNING -> org.bukkit.entity.EntityType.LIGHTNING
            EntityType.LINGERING_POTION -> org.bukkit.entity.EntityType.LINGERING_POTION
            EntityType.LLAMA -> org.bukkit.entity.EntityType.LLAMA
            EntityType.LLAMA_SPIT -> org.bukkit.entity.EntityType.LLAMA_SPIT
            EntityType.MAGMA_CUBE -> org.bukkit.entity.EntityType.MAGMA_CUBE
            EntityType.MINECART -> org.bukkit.entity.EntityType.MINECART
            EntityType.MINECART_CHEST -> org.bukkit.entity.EntityType.MINECART_CHEST
            EntityType.MINECART_COMMAND -> org.bukkit.entity.EntityType.MINECART_COMMAND
            EntityType.MINECART_FURNACE -> org.bukkit.entity.EntityType.MINECART_FURNACE
            EntityType.MINECART_HOPPER -> org.bukkit.entity.EntityType.MINECART_HOPPER
            EntityType.MINECART_MOB_SPAWNER -> org.bukkit.entity.EntityType.MINECART_MOB_SPAWNER
            EntityType.MINECART_TNT -> org.bukkit.entity.EntityType.MINECART_TNT
            EntityType.MULE -> org.bukkit.entity.EntityType.MULE
            EntityType.MUSHROOM_COW -> org.bukkit.entity.EntityType.MUSHROOM_COW
            EntityType.OCELOT -> org.bukkit.entity.EntityType.OCELOT
            EntityType.PAINTING -> org.bukkit.entity.EntityType.PAINTING
            EntityType.PARROT -> org.bukkit.entity.EntityType.PARROT
            EntityType.PHANTOM -> org.bukkit.entity.EntityType.PHANTOM
            EntityType.PIG -> org.bukkit.entity.EntityType.PIG
            EntityType.PIG_ZOMBIE -> org.bukkit.entity.EntityType.PIG_ZOMBIE
            EntityType.PLAYER -> org.bukkit.entity.EntityType.PLAYER
            EntityType.POLAR_BEAR -> org.bukkit.entity.EntityType.POLAR_BEAR
            EntityType.PRIMED_TNT -> org.bukkit.entity.EntityType.PRIMED_TNT
            EntityType.PUFFERFISH -> org.bukkit.entity.EntityType.PUFFERFISH
            EntityType.RABBIT -> org.bukkit.entity.EntityType.RABBIT
            EntityType.SALMON -> org.bukkit.entity.EntityType.SALMON
            EntityType.SHEEP -> org.bukkit.entity.EntityType.SHEEP
            EntityType.SHULKER -> org.bukkit.entity.EntityType.SHULKER
            EntityType.SHULKER_BULLET -> org.bukkit.entity.EntityType.SHULKER_BULLET
            EntityType.SILVERFISH -> org.bukkit.entity.EntityType.SILVERFISH
            EntityType.SKELETON -> org.bukkit.entity.EntityType.SKELETON
            EntityType.SKELETON_HORSE -> org.bukkit.entity.EntityType.SKELETON_HORSE
            EntityType.SLIME -> org.bukkit.entity.EntityType.SLIME
            EntityType.SMALL_FIREBALL -> org.bukkit.entity.EntityType.SMALL_FIREBALL
            EntityType.SNOWBALL -> org.bukkit.entity.EntityType.SNOWBALL
            EntityType.SNOWMAN -> org.bukkit.entity.EntityType.SNOWMAN
            EntityType.SPECTRAL_ARROW -> org.bukkit.entity.EntityType.SPECTRAL_ARROW
            EntityType.SPIDER -> org.bukkit.entity.EntityType.SPIDER
            EntityType.SPLASH_POTION -> org.bukkit.entity.EntityType.SPLASH_POTION
            EntityType.SQUID -> org.bukkit.entity.EntityType.SQUID
            EntityType.STRAY -> org.bukkit.entity.EntityType.STRAY
            EntityType.THROWN_EXP_BOTTLE -> org.bukkit.entity.EntityType.THROWN_EXP_BOTTLE
            EntityType.TIPPED_ARROW -> org.bukkit.entity.EntityType.TIPPED_ARROW
            EntityType.TRIDENT -> org.bukkit.entity.EntityType.TRIDENT
            EntityType.TROPICAL_FISH -> org.bukkit.entity.EntityType.TROPICAL_FISH
            EntityType.TURTLE -> org.bukkit.entity.EntityType.TURTLE
            EntityType.VEX -> org.bukkit.entity.EntityType.VEX
            EntityType.VILLAGER -> org.bukkit.entity.EntityType.VILLAGER
            EntityType.VINDICATOR -> org.bukkit.entity.EntityType.VINDICATOR
            EntityType.WEATHER -> org.bukkit.entity.EntityType.WEATHER
            EntityType.WITCH -> org.bukkit.entity.EntityType.WITCH
            EntityType.WITHER -> org.bukkit.entity.EntityType.WITHER
            EntityType.WITHER_SKELETON -> org.bukkit.entity.EntityType.WITHER_SKELETON
            EntityType.WITHER_SKULL -> org.bukkit.entity.EntityType.WITHER_SKULL
            EntityType.WOLF -> org.bukkit.entity.EntityType.WOLF
            EntityType.ZOMBIE -> org.bukkit.entity.EntityType.ZOMBIE
            EntityType.ZOMBIE_HORSE -> org.bukkit.entity.EntityType.ZOMBIE_HORSE
            EntityType.ZOMBIE_VILLAGER -> org.bukkit.entity.EntityType.ZOMBIE_VILLAGER
        }
    }
}