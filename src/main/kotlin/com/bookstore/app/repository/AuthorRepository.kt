package com.bookstore.app.repository

import com.bookstore.app.entity.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Int> {
    fun findAuthorByLastName(lastName: String): Author
}
