package com.bookstore.app.error

import org.springframework.http.HttpStatus

enum class ErrorCodes(
    val errorCode: Int,
    val message: String,
    val httpStatus: HttpStatus
) {
    SERVER_ERROR(5000, "Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    NUMBER_FORMAT_EXCEPTION(4010, "Number format exception", HttpStatus.BAD_REQUEST),
    INVALID_FORMAT_EXCEPTION(4011, "Invalid format exception", HttpStatus.BAD_REQUEST)

}