package com.bookstore.app.repository

import com.bookstore.app.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository: JpaRepository<User, Int> {
    fun existsUserByUsername(username: String): Boolean
}