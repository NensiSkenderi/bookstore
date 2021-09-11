package com.bookstore.app.dto

import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
data class AuthorDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val book: List<BookDto> = listOf()
) {
    constructor() : this(0, "", "")
}
