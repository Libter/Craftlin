package net.craftlin.plugin.bukkit.impl.value

import net.craftlin.plugin.api.value.BlockType
import net.craftlin.plugin.api.value.base.EnumValue
import org.bukkit.Material

object BukkitBlockType: EnumValue<BlockType, Material>(BlockType::class) {
    override fun convert(api: BlockType): Material {
        return when(api) {
            BlockType.AIR -> Material.AIR
            BlockType.DIRT -> Material.DIRT
        }
    }
}