package com.bookstore.app.error

class BookstoreErrorDto (
    val errorCode: Int,
    val message: String,
    val detailedMessage: String,
    val traceId: String
) {
    constructor (errorCode: ErrorCodes, detailedMessage: String, traceId: String) : this(
        errorCode.errorCode,
        errorCode.message,
        detailedMessage,
        traceId
    )
}