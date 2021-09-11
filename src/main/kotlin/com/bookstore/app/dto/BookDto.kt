package com.bookstore.app.dto

import com.bookstore.app.entity.BookCategory
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
data class BookDto (
    val id: Int,
    val name: String,
    @JsonProperty("page_number")
    val numberOfPages: Int,
    val quantity: Int,
    val price: Double,
    @JsonIgnore
    val category: BookCategory,
    val author: AuthorDto
)


