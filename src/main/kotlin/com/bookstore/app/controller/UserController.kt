package com.bookstore.app.controller

import com.bookstore.app.dto.UserDto
import com.bookstore.app.entity.CustomUserDetails
import com.bookstore.app.service.UserService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@Api(value = "User Information", tags = ["User"])
@RestController
@RequestMapping("api/v1/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("user/{id}")
    fun getUserById(@PathVariable id: Int): UserDto {
        val customUserDetails = SecurityContextHolder.getContext().authentication.principal as CustomUserDetails
        return if(customUserDetails.id != id)
            Optional.empty<UserDto>().orElseThrow()
        else userService.getUserById(id)
    }

}
