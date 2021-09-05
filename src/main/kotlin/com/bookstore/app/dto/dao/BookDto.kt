package com.bookstore.app.dto.dao

import lombok.Data

@Data
class BookDto (
    private val id: Int,
    private val name: String,
    private val numberOfPages: Int,
    private val quantity: Int,
    private val price: Double
)