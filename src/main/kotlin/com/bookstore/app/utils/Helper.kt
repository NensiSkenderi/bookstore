package com.bookstore.app.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object Helper {

    fun createObjectMapper() = try {
        jacksonObjectMapper().registerModule(JavaTimeModule())
    } catch (e: Exception) {
        ObjectMapper()
    }
}
