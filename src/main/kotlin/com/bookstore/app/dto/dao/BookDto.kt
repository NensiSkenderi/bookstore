package com.bookstore.app.dto.dao

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
data class BookDto (
    val id: Int,
    val name: String,
    val numberOfPages: Int,
    val quantity: Int,
    val price: Double
)


