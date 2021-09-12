package com.bookstore.app.service.impl

import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Book
import com.bookstore.app.mappers.BookMapper
import com.bookstore.app.repository.BookRepository
import com.bookstore.app.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl() : BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var bookMapper: BookMapper

    override fun getAllBooks(): List<BookDto> {
        val bookDtoList: MutableList<BookDto> = mutableListOf()
        val bookList = bookRepository.findAll()
        for (book: Book in bookList) {
            bookDtoList.add(bookMapper.toDto(book))
        }
        return bookDtoList
    }

    override fun getBookById(bookId: Int): BookDto {
        val book = bookRepository.findById(bookId).get()
        return bookMapper.toDto(book)
    }

    override fun addBook(bookDto: BookDto): String {
        val book = bookMapper.toEntity(bookDto)
        bookRepository.save(book)
        return "Book added successfully!"
    }

    override fun deleteBookById(bookId: Int): String {
        val exists: Boolean = bookRepository.existsById(bookId)
        return if (exists) {
            bookRepository.deleteById(bookId)
            "Book deleted successfully!"
        } else
            "Book does not exists!"
    }
}
