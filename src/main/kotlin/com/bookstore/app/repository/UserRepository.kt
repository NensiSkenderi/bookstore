package com.bookstore.app.repository

import com.bookstore.app.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun existsUserByUsername(username: String): Boolean
    fun findByUsername(name: String): User
}
