package ru.kotlin

fun main() {
    val strBox: Box<String> = Box("String 1")
    val nStrBox: Box<String?> = Box(null)

    val strValue: String = strBox.getValue()
    val nStrValue: String? = nStrBox.getValue()
}

class Box<T : CharSequence?>(private val value: T) {
    fun getValue(): T = value
    fun getLength(): Int = value?.length ?: 0
}