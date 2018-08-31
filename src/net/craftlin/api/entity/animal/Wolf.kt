package net.craftlin.api.entity.animal

import net.craftlin.api.entity.base.GrowingEntity
import net.craftlin.api.entity.base.TameableEntity
import net.craftlin.api.value.DyeColor

interface Wolf: GrowingEntity, TameableEntity {
    /**
     * Wolf's collar color
     * @see DyeColor
     */
    var collarColor: String
    /**
     * Whether the wolf is angry or not
     */
    var angry: Boolean
}