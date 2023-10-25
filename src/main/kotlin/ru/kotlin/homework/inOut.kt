package ru.kotlin.homework


fun main() {
    val circleGroup = Group<Circle>()
    circleGroup.insert(Circle)
    val fromGroup = circleGroup.fetch()
    println("From group: $fromGroup")

    val readGroup: ReadGroup<Shape> = circleGroup
    val fromReadGroup: Shape = readGroup.fetch()
    println("From read group: $fromReadGroup")
}

interface ReadGroup<out T> {
    fun fetch(): T
}

open class Group<T> : ReadGroup<T> {
    private val items: MutableList<T> = mutableListOf()
    fun insert(item: T) {
        items.add(item)
    }
    override fun fetch(): T {
        return items.last()
    }
}