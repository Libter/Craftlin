package net.craftlin.api.misc

typealias Block = () -> Unit

typealias ItBlock<T> = (T) -> Unit

typealias ThisBlock<T> = T.() -> Unit

typealias ThisResultBlock<T, R> = T.() -> R