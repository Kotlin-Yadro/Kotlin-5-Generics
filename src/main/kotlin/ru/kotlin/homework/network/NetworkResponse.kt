@file:Suppress("unused")

package ru.kotlin.homework.network

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

/**
 * Network result
 */
sealed class NetworkResponse<T, R> {
    val responseDateTime: LocalDateTime = LocalDateTime.now()
}

/**
 * Network success
 */
data class Success<T, R>(val resp: T): NetworkResponse<T, R>()

/**
 * Network error
 */
data class Failure<T, R>(val error: R): NetworkResponse<T, R>()

val s1 = Success("Message")
val r11: NetworkResponse<String, Error> = s1
val r12: NetworkResponse<Any, Error> = s1

val s2 = Success("Message")
val r21: NetworkResponse<String, Exception> = s2
val r22: NetworkResponse<Any, Exception> = s2

val s3 = Success(String())
val r31: Success<CharSequence> = s3
val r32: Success<Any> = s3

val e = Failure(Error())
val er1: NetworkResponse<String, Error> = e
val er2: NetworkResponse<Any, Error> = e
val er4: NetworkResponse<Any, Throwable> = e

val er5: NetworkResponse<Int, Throwable> = Failure(IllegalArgumentException("message"))

val message = e.error.message