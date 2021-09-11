package com.bookstore.app.dto

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Data
import java.time.LocalDate
import java.util.*

@Data
@AllArgsConstructor
data class UserDto(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String?,
    val email: String,
    val password: String,
    val isAdmin: Boolean,
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    val createdAt: LocalDate = LocalDate.now()
)
