package com.bookstore.app.service

import com.bookstore.app.entity.Book

interface BookService {
    fun getAllBooks(): List<Book>
    fun getBookById(bookId: Int): Book
}