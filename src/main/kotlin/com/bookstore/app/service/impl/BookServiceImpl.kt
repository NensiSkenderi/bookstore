package com.bookstore.app.service.impl

import com.bookstore.app.entity.Book
import com.bookstore.app.repository.BookRepository
import com.bookstore.app.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl() : BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    override fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    override fun getBookById(bookId: Int): Book {
        return bookRepository.findById(bookId).get()
    }
}