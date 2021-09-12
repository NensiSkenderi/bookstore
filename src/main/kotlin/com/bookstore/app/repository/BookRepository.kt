package com.bookstore.app.repository

import com.bookstore.app.entity.Author
import com.bookstore.app.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface BookRepository : JpaRepository<Book, Int> {
    fun findAllByAuthor(@Param("author") author: Author): List<Book>
}
