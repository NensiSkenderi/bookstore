package com.bookstore.app.mappers

import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Book

interface BookMapper {
    fun bookToBookDto(book: Book): BookDto

    fun bookDtoToBook(bookDto: BookDto): Book
}
