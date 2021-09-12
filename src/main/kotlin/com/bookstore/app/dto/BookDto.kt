package com.bookstore.app.dto

import com.bookstore.app.dto.view.View
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonView
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

    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    var author: AuthorDto? = null
}
