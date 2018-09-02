package net.craftlin.api.value.entity.modifier

enum class EffectType {
    ABSORPTION,
    BLINDNESS,
    CONDUIT_POWER,
    CONFUSION,
    DAMAGE_RESISTANCE,
    DOLPHINS_GRACE,
    FAST_DIGGING,
    FIRE_RESISTANCE,
    GLOWING,
    HARM,
    HEAL,
    HEALTH_BOOST,
    HUNGER,
    INCREASE_DAMAGE,
    INVISIBILITY,
    JUMP,
    LEVITATION,
    LUCK,
    NIGHT_VISION,
    POISON,
    REGENERATION,
    SATURATION,
    SLOW,
    SLOW_DIGGING,
    SLOW_FALLING,
    SPEED,
    UNLUCK,
    WATER_BREATHING,
    WEAKNESS,
    WITHER;

    companion object {
        operator fun get(string: String): EffectType {
            return values().filter { it.name == string.toUpperCase().replace(" ", "_") }.getOrNull(0) ?: throw NotImplementedError()
        }
    }
}