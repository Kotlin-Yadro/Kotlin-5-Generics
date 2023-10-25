@file:Suppress("RedundantExplicitType", "UNUSED_VARIABLE")

package ru.kotlin.homework

fun main() {
    val str: String = "Some string"
    val obj: Any = str

    val strList: List<String> = listOf(str)
    val objList: List<Any> = strList

    println("List of objects: $objList")
}