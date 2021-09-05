package com.bookstore.app.service

import com.bookstore.app.dto.BookDto

interface BookService {
    fun getAllBooks(): List<BookDto>
    fun getBookById(bookId: Int): BookDto
    fun addBook(bookDto: BookDto): String
    fun deleteBookById(bookId: Int): String
}