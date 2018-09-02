package net.craftlin.api.world.block

import net.craftlin.api.value.world.DoorHinge

/**
 * Represents a Minecraft door.
 */
interface Door: Openable {

    /** @see DoorHinge */
    val hinge: String

}