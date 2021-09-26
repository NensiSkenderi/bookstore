package com.bookstore.app.error

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ControllerHandler {

    val logger: Logger = LoggerFactory.getLogger(ControllerHandler::class.java)

    @ExceptionHandler(value = [(RuntimeException::class)])
    fun handleAnyException(e: RuntimeException): ResponseEntity<BookstoreErrorDto> {
        logger.error(e.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BookstoreErrorDto(ErrorCodes.SERVER_ERROR, e.message ?: "", UUID.randomUUID().toString()))
    }

    @ExceptionHandler(value = [(NumberFormatException::class)])
    fun numberFormatException(e: Throwable): ResponseEntity<BookstoreErrorDto> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BookstoreErrorDto(ErrorCodes.NUMBER_FORMAT_EXCEPTION, e.message ?: "", UUID.randomUUID().toString()))
    }

    @ExceptionHandler(value = [(InvalidFormatException::class)])
    fun invalidFormatException(e: Throwable): ResponseEntity<BookstoreErrorDto> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BookstoreErrorDto(ErrorCodes.INVALID_FORMAT_EXCEPTION, e.message ?: "", UUID.randomUUID().toString()))
    }

}