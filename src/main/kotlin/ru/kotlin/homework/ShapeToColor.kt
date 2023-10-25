package ru.kotlin.homework

import java.lang.IllegalArgumentException

open class ShapeToColor {
    open fun process(shape: Shape): Color = when(shape) {
        is Square -> Red
        is Circle -> Blue
        else -> throw IllegalArgumentException("Unknown shape")
    }
}