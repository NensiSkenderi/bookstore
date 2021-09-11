
package com.bookstore.app.mappers.impl

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Author
import com.bookstore.app.entity.Book
import com.bookstore.app.mappers.AuthorMapper
import com.bookstore.app.mappers.BookMapper
import org.springframework.stereotype.Component

@Component
class BookMapperImpl(
    val authorMapper: AuthorMapper
) : BookMapper {

    override fun bookToBookDto(book: Book): BookDto {
        if (book == null)
            return book

        val bookDto = BookDto()
        bookDto.apply {
            id = book.id
            name = book.name
            author = authorMapper.authorToAuthorDto(book.author)
            quantity = book.quantity
            price = book.price
            numberOfPages = numberOfPages
        }
        return bookDto
    }

    override fun bookDtoToBook(bookDto: BookDto): Book {
        if (bookDto == null)
            return bookDto

        val book = Book()
        book.apply {
            id = bookDto.id
            name = bookDto.name
            author = bookDto.author?.let { authorMapper.authorDtoToAuthor(it) }!!
            quantity = bookDto.quantity
            price = bookDto.price
        }
        return book
    }
}
