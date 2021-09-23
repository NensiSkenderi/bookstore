package com.bookstore.app.controller

import com.bookstore.app.dto.BookDto
import com.bookstore.app.dto.UserDto
import com.bookstore.app.service.BookService
import com.bookstore.app.service.UserService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Api(value = "User Information", tags = ["User"])
@RestController
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("user/{id}")
    fun getUserById(@PathVariable id: Int): UserDto {
        return userService.getUserById(id)
    }

    @PostMapping("user")
    fun addUser(@RequestBody @Valid userDto: UserDto): String {
        return userService.addUser(userDto, 0)
    }

//    @DeleteMapping("books/{id}")
//    fun deleteBook(@PathVariable id: Int): String {
//        return bookService.deleteBookById(id)
//    }
}