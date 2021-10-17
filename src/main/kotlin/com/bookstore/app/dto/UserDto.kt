package com.bookstore.app.dto

import com.fasterxml.jackson.annotation.JsonFormat
import lombok.AllArgsConstructor
import lombok.Data
import java.time.LocalDate

@Data
@AllArgsConstructor
data class UserDto(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String?,
    val email: String,
    var role: String,
    val password: String,
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val createdAt: LocalDate = LocalDate.now()
)
