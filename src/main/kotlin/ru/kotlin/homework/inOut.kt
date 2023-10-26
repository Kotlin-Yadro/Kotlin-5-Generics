package ru.kotlin.homework


fun main() {
    val circleGroup = Group<Circle>()
    circleGroup.insert(Circle)
    val fromGroup = circleGroup.fetch()
    println("From group: $fromGroup")

    val readGroup: Group<out Shape> = circleGroup
    val fromReadGroup: Shape = readGroup.fetch()
    println("From read group: $fromReadGroup")
    fetcher(circleGroup)

    val shapeGroup = Group<Shape>()
    val writeCircleGroup: Group<in Circle> = shapeGroup
    writeCircleGroup.insert(Circle)
    val writeTriangleGroup: Group<in Triangle> = shapeGroup
    writeTriangleGroup.insert(Triangle)
    putter(shapeGroup, Circle)

    val fromShapeGroup: Shape = shapeGroup.fetch()
    println("From shape group: $fromShapeGroup")

    var anyGroup: Group<*> = circleGroup
    println(measure(anyGroup))
    anyGroup = readGroup
    println(measure(anyGroup))
    anyGroup = shapeGroup
    println(measure(anyGroup))

    idOfFetched(anyGroup)
}

open class Group<T> {
    private val items: MutableList<T> = mutableListOf()

    fun getSize(): Int = items.size

    fun insert(item: T) {
        items.add(item)
    }
    fun fetch(): T {
        return items.last()
    }
}

fun fetcher(group: Group<out Shape>) {
    val fetched = group.fetch()
    println(fetched)
}
fun putter(group: Group<in Circle>, item: Circle) {
    group.insert(item)
}
fun measure(group: Group<*>) {
    println("Size of group: ${group.getSize()}")
}
fun idOfFetched(group: Group<*>) {
    val fetched: Any? = group.fetch()
    println("No ID on fetched")
}