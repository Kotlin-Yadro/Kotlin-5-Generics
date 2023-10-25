package ru.kotlin.homework


fun main() {
    val circleGroup = Group<Circle>()
    circleGroup.insert(Circle)
    val fromGroup = circleGroup.fetch()
    println("From group: $fromGroup")

    val readGroup: ReadGroup<Shape> = circleGroup
    val fromReadGroup: Shape = readGroup.fetch()
    println("From read group: $fromReadGroup")

    val shapeGroup = Group<Shape>()
    val writeCircleGroup: WriteGroup<Circle> = shapeGroup
    writeCircleGroup.insert(Circle)
    val writeTriangleGroup: WriteGroup<Triangle> = shapeGroup
    writeTriangleGroup.insert(Triangle)

    val fromShapeGroup: Shape = shapeGroup.fetch()
    println("From shape group: $fromShapeGroup")
}

interface ReadGroup<out T> {
    fun fetch(): T
}

interface WriteGroup<in T> {
    fun insert(item: T)
}

open class Group<T> : ReadGroup<T>, WriteGroup<T> {
    private val items: MutableList<T> = mutableListOf()
    override fun insert(item: T) {
        items.add(item)
    }
    override fun fetch(): T {
        return items.last()
    }
}