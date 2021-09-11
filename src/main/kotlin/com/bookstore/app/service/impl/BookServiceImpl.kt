package com.bookstore.app.service.impl

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Author
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

    override fun getBookById(bookId: Int): BookDto {
        val book = bookRepository.findById(bookId).get()
        return book.toBookDto()
    }

    override fun addBook(bookDto: BookDto): String {
        val book = bookDto.toBookEntity()
        bookRepository.save(book)
        return "Book added successfully!"
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

    fun Book.toBookDto() = BookDto(
        id = id,
        name = name,
        numberOfPages = numberOfPages,
        quantity = quantity,
        price = price,
        category = category,
        author = AuthorDto() //check this because it misses data
    )

    fun BookDto.toBookEntity() = Book(
        id = id,
        name = name,
        numberOfPages = numberOfPages,
        quantity = quantity,
        price = price,
        category = category,
        author = Author()
    )
}