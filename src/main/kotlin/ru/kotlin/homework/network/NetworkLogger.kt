@file:Suppress("unused")

package ru.kotlin.homework.network

import ru.kotlin.homework.Circle
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

/**
 * Известный вам список ошибок
 */
sealed class ApiException(message: String) : Throwable(message) {
    data object NotAuthorized : ApiException("Not authorized")
    data object NetworkException : ApiException("Not connected")
    data object UnknownException: ApiException("Unknown exception")
}

class ErrorLogger<E : Any> {

    val errors = mutableListOf<Pair<LocalDateTime, E>>()

    fun log(response: NetworkResponse<*, *>) {
        if (response is Failure) {
            errors.add((response.responseDateTime to response.error) as Pair<LocalDateTime, E>)
        }
    }

    fun dumpLog() {
        errors.forEach { (date, error) ->
            println("Error at $date: ${(error as Throwable).message}")
        }
    }

    fun dump(): List<Pair<LocalDateTime, E>> {
        return errors
    }
}

fun processThrowables(logger: ErrorLogger<Throwable>) {
    logger.log(Success("Success"))
    Thread.sleep(100)
    logger.log(Success(Circle))
    Thread.sleep(100)
    logger.log(Failure(IllegalArgumentException("Something unexpected")))

    logger.dumpLog()
}

fun processApiErrors(apiExceptionLogger: ErrorLogger<*>) {
    apiExceptionLogger.log(Success("Success"))
    Thread.sleep(100)
    apiExceptionLogger.log(Success(Circle))
    Thread.sleep(100)
    apiExceptionLogger.log(Failure(ApiException.NetworkException))

    apiExceptionLogger.dumpLog()
}

fun main() {
    val logger = ErrorLogger<Throwable>()

    println("Processing Throwable:")
    processThrowables(logger)

    println("Processing Api:")
    processApiErrors(logger)

    println("List of errors: ${logger.dump()}")
}

