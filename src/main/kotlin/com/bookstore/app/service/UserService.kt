package com.bookstore.app.service

import com.bookstore.app.dto.UserDto
import com.bookstore.app.entity.User

interface UserService {
    fun getUserById(userId: Int): UserDto
    fun addUser(userDto: UserDto): String
    fun deleteUserById(userId: Int): String
    fun getUserByUsername(username: String): UserDto
}
