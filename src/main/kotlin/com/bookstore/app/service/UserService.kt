package com.bookstore.app.service

import com.bookstore.app.dto.UserDto

interface UserService {
    fun getUserById(userId: Int): UserDto
    fun addUser(userDto: UserDto, isAdmin: Boolean): String
    fun deleteUserById(userId: Int): String
    fun getUserByUsername(username: String): UserDto
}
