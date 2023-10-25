package ru.kotlin.homework


fun main() {
    val producer: ShapeProducer = CircleProducer()
    println(producer.produce())
}

open class ShapeProducer {
    open fun produce(): Shape {
        return Square
    }
}

class CircleProducer : ShapeProducer() {
    override fun produce(): Circle {
        return Circle
    }
}