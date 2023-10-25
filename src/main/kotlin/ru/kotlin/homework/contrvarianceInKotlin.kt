package ru.kotlin.homework

fun main() {
    val processor: ToExtendCircle = ToExtendShape()
    processor.process(Circle)

    val shapeProcessor: ToExtendShape = processor as ToExtendShape
    shapeProcessor.process(Square)
}

open class ToExtendCircle {
    open fun process(value: Circle) {
        println(value)
    }
}

class ToExtendShape : ToExtendCircle() {
    fun process(value: Shape) = when(value) {
        is Circle -> super.process(value)
        else -> println("Any: $value")
    }
}