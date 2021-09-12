package com.bookstore.app.service.impl

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.dto.BookDto
import com.bookstore.app.mappers.AuthorMapper
import com.bookstore.app.mappers.BookMapper
import com.bookstore.app.repository.AuthorRepository
import com.bookstore.app.repository.BookRepository
import com.bookstore.app.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    val bookMapper: BookMapper
) : AuthorService {

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var authorMapper: AuthorMapper

    override fun getBooksByAuthor(lastName: String): List<BookDto> {
        val bookList = mutableListOf<BookDto>()
        val author = authorRepository.findAuthorByLastName(lastName)
        val booksByAuthor = bookRepository.findAllByAuthor(author)
        booksByAuthor.forEach {
            bookList.add(bookMapper.toDto(it))
        }
        return bookList
    }

    override fun getAuthorById(authorId: Int): AuthorDto {
        val author = authorRepository.findById(authorId).get()
        return authorMapper.toDto(author)
    }

    override fun getAllAuthors(): List<AuthorDto> {
        val authorDtoList = mutableListOf<AuthorDto>()
        authorRepository.findAll().forEach {
            authorDtoList.add(authorMapper.toDto(it))
        }
        return authorDtoList
    }


}
