@file:Suppress("RedundantExplicitType")

package ru.kotlin.homework

import java.lang.IllegalArgumentException

private val matcher: ShapeToColor = AllInRed()

fun main() {
    println("Square: ${process(Square)}")
    println("Circle: ${process(Circle)}")
}

fun process(shape: Shape) = when(matcher.process(shape)) {
    Red -> "Красный"
    Blue -> "Голубой"
    else -> throw IllegalArgumentException("Неизвестный цвет")
}