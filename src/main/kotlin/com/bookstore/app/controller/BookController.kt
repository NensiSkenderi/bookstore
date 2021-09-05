package com.bookstore.app.controller

import com.bookstore.app.dto.BookDto
import com.bookstore.app.service.BookService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Api(value = "Book Information", tags = ["Book"])
@RestController
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping("books")
    fun getAllBooks(): List<BookDto> {
        return bookService.getAllBooks()
    }

    @GetMapping("books/{id}")
    fun getBookById(@PathVariable id: Int): BookDto {
        return bookService.getBookById(id)
    }

    @PostMapping("books")
    fun addBook(@RequestBody @Valid bookDto: BookDto): String {
        return bookService.addBook(bookDto)
    }

    @DeleteMapping("books/{id}")
    fun deleteBook(@PathVariable id: Int): String {
        return bookService.deleteBookById(id)
    }
}