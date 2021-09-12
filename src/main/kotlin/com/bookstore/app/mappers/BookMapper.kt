package com.bookstore.app.mappers

import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Book

interface BookMapper {
    fun toDto(book: Book): BookDto

    fun toEntity(bookDto: BookDto): Book
}
