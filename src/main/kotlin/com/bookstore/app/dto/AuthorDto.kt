package com.bookstore.app.dto

import com.bookstore.app.dto.view.View
import com.fasterxml.jackson.annotation.JsonView
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
data class AuthorDto(
    var id: Int,
    var firstName: String,
    var lastName: String,

    var book: List<BookDto> = listOf()
) {
    constructor() : this(0, "", "")
}
