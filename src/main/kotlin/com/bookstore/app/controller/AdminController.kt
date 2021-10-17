package com.bookstore.app.controller

import com.bookstore.app.dto.UserDto
import com.bookstore.app.service.UserService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Api(value = "Admin User Information", tags = ["User"])
@RestController
@RequestMapping("admin/api/v1/users")
class AdminController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping("addUser")
    fun addUser(@RequestBody @Valid userDto: UserDto): String {
        return userService.addUser(userDto)
    }

    @DeleteMapping("user/{id}")
    fun deleteUser(@PathVariable id: Int): String {
        return userService.deleteUserById(id)
    }
}