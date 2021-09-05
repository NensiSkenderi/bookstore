package com.bookstore.app.controller

import com.bookstore.app.dto.dao.BookDto
import com.bookstore.app.entity.Book
import com.bookstore.app.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping("books")
    fun getAllBooks(): List<BookDto> {
        return bookService.getAllBooks()
    }
}