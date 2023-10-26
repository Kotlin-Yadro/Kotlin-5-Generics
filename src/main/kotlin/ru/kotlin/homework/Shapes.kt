package ru.kotlin.homework

import kotlin.random.Random

abstract class Shape {
    val id: Int = Random.nextInt()
}

data object Square: Shape()
data object Circle: Shape()
data object Triangle: Shape()