package net.craftlin.api.misc

typealias emptyF = () -> Unit

typealias itF<T> = (T) -> Unit

typealias thisF<T> = T.() -> Unit