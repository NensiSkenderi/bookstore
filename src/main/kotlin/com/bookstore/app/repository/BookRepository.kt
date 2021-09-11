package com.bookstore.app.repository

import com.bookstore.app.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int>
