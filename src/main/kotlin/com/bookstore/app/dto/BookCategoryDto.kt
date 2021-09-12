package com.bookstore.app.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
data class BookCategoryDto(
    var id: Int,
    var name: String,

    @JsonIgnore
    var book: List<BookDto?> = emptyList()
) {
    constructor() : this(0, "")
}
