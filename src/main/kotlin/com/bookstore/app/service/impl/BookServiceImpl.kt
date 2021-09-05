package com.bookstore.app.service.impl

import com.bookstore.app.dto.dao.BookDto
import com.bookstore.app.dto.mapper.BookMapper
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
        for (book: Book in bookList){
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


    override fun getBookById(bookId: Int): BookDto {
        val book = bookRepository.findById(bookId).get()
//        val bookDto = BookDto(
//            id = book.id,
//            name = book.name,
//            numberOfPages = book.numberOfPages,
//            price = book.price,
//            quantity = book.quantity
//        )
        return book.toBookDto()
    }
}