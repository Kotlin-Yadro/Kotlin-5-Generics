package ru.kotlin.homework

fun main() {
    val processor: ToExtendCircle = ToExtendCircle()
    processor.process(Circle)
}

open class ToExtendCircle {
    open fun process(value: Circle) {
        println(value)
    }
}

class ToExtendAny : ToExtendCircle() {
    override fun process(value: Shape) {

    }
}