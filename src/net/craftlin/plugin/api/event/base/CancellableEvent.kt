package net.craftlin.plugin.api.event.base

abstract class CancellableEvent: Event() {
    abstract var isCancelled: Boolean
}