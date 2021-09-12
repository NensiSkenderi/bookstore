package com.bookstore.app.service

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.dto.BookDto

interface AuthorService {
    fun getBooksByAuthor(lastName: String): List<BookDto>
    fun getAuthorById(authorId: Int): AuthorDto
    fun getAllAuthors(): List<AuthorDto>
}
