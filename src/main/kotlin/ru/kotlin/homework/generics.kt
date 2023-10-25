@file:Suppress("RedundantExplicitType")

package ru.kotlin.homework

fun main() {
    val str: String = "Some string"
    val obj: Any = str

    val strArray: Array<String> = arrayOf(str)
    val objArray: Array<Any> = strArray

    println("String as object: $obj")
}