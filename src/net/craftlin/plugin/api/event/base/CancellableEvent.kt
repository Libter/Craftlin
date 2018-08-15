package net.craftlin.plugin.api.event.base

interface CancellableEvent: Event {
    var cancelled: Boolean
}