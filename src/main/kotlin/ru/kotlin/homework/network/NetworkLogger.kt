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

class ErrorLogger<E : Throwable> {

    private val errors: MutableList<Pair<LocalDateTime, E>> = mutableListOf()

    fun log(response: NetworkResponse<*, E>) {
        if (response is Failure) {
            errors.add(response.responseDateTime to response.error)
        }
    }

    fun dumpLog() {
        errors.forEach { (date, error) ->
            println("Error at $date: ${error.message}")
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

    val errors = logger.dump()
    println("Errors: $errors")
}

fun processApiErrors(apiExceptionLogger: ErrorLogger<in ApiException>) {
    apiExceptionLogger.log(Success("Success"))
    Thread.sleep(100)
    apiExceptionLogger.log(Success(Circle))
    Thread.sleep(100)
    apiExceptionLogger.log(Failure(ApiException.NetworkException))

    apiExceptionLogger.dumpLog()

    val errors = apiExceptionLogger.dump()
    println("Errors: $errors")
}

fun main() {
    val logger = ErrorLogger<Throwable>()

    println("Processing Throwable:")
    processThrowables(logger)

    println("Processing Api:")
    processApiErrors(logger)
}

