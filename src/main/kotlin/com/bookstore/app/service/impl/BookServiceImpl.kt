package com.bookstore.app.service.impl

import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Book
import com.bookstore.app.repository.BookRepository
import com.bookstore.app.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl() : BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    override fun getAllBooks(): List<BookDto> {
        val bookDtoList: MutableList<BookDto> = mutableListOf()
        val bookList = bookRepository.findAll()
        for (book: Book in bookList) {
            bookDtoList.add(book.toBookDto())
        }
        return bookDtoList
    }

    fun Book.toBookDto() = BookDto(
        id = id,
        name = name,
        numberOfPages = numberOfPages,
        quantity = quantity,
        price = price
    )

    fun BookDto.toBookEntity() = Book(
        id = id,
        name = name,
        numberOfPages = numberOfPages,
        quantity = quantity,
        price = price
    )

    override fun getBookById(bookId: Int): BookDto {
        val book = bookRepository.findById(bookId).get()
        return book.toBookDto()
    }

    override fun addBook(bookDto: BookDto): String {
        val book = bookDto.toBookEntity()
        bookRepository.save(book)
        return "Book Saved!"
    }

    override fun deleteBookById(bookId: Int): String {
        val exists: Boolean = bookRepository.existsById(bookId)
        return if (exists) {
            bookRepository.deleteById(bookId)
            "Book deleted successfully!"
        }
        else
            "Book does not exists!"
    }
}