package com.bookstore.app.dto

import com.bookstore.app.dto.view.View
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonView
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class BookDto {

    /* with this JsonView we say that only these fields will be displayed in the response
    when we call the controller method
    is annotated with this
     */
    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    var id: Int = 0

    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    var name: String = ""

    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    @JsonProperty("page_number")
    var numberOfPages: Int = 0

    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    var quantity: Int = 0

    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    var price: Double = 0.0

    var category: BookCategoryDto? = null

    var author: AuthorDto? = null
}
