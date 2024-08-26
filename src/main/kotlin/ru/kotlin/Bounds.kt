package ru.kotlin

fun main() {
    val strBox: Box<MyString> = Box(MyString("String 1"))
    val nStrBox: Box<MyString?> = Box(null)

    val strValue: CharSequence = strBox.getValue()
    val nStrValue: CharSequence? = nStrBox.getValue()
}

data class MyString(val value: String): CharSequence by value, FirstChar {
    override val firstChar: Char get() = value[0]
}

interface FirstChar {
    val firstChar: Char
}

class Box<T>(private val value: T) where T : CharSequence?, T : FirstChar? {
    fun getValue(): T = value
    fun getLength(): Int = value?.length ?: 0
    fun getFirstChar(): Char? = value?.firstChar
}