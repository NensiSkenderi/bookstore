package com.bookstore.app.controller

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.dto.BookDto
import com.bookstore.app.dto.view.View
import com.bookstore.app.service.AuthorService
import com.bookstore.app.service.BookService
import com.fasterxml.jackson.annotation.JsonView
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Api(value = "Author Information", tags = ["Author"])
@RestController
class AuthorController {

    @Autowired
    private lateinit var authorService: AuthorService

    @GetMapping("authors")
    fun getAllAuthors(): List<AuthorDto> {
        return authorService.getAllAuthors()
    }

    @GetMapping("authors/{id}")
    fun getAuthorById(@PathVariable id: Int): AuthorDto {
        return authorService.getAuthorById(id)
    }

    @JsonView(View.ViewOnlyInGetBooksByAuthor::class)
    @GetMapping("author")
    fun getAuthorById(@RequestParam lastName: String): List<BookDto> {
        return authorService.getBooksByAuthor(lastName)
    }

//    @PostMapping("author")
//    fun addBook(@RequestBody @Valid authorDto: AuthorDto): String {
//        return authorService.add(bookDto)
//    }
//
    @DeleteMapping("authors/{id}")
    fun deleteAuthor(@PathVariable id: Int): String {
        return authorService.deleteAuthorById(id)
    }
}
