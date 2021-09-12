package com.bookstore.app.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class BookDto {
    var id: Int = 0
    var name: String = ""

    @JsonProperty("page_number")
    var numberOfPages: Int = 0
    var quantity: Int = 0
    var price: Double = 0.0

    var category: BookCategoryDto? = null
    var author: AuthorDto? = null
}
