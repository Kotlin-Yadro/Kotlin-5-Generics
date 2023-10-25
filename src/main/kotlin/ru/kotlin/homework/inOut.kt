package ru.kotlin.homework


fun main() {
    val circleGroup = Group<Circle>()
    circleGroup.insert(Circle)
    val fromGroup = circleGroup.fetch()
    println("From group: $fromGroup")

    val shapeGroup: Group<Shape> = circleGroup
    val fromShapeGroup: Shape = shapeGroup.fetch()
    println("From shape group: $fromShapeGroup")
}

open class Group<T> {
    private val items: MutableList<T> = mutableListOf()
    fun insert(item: T) {
        items.add(item)
    }
    fun fetch(): T {
        return items.last()
    }
}