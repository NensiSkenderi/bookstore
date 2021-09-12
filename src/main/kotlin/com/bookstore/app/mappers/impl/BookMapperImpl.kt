
package com.bookstore.app.mappers.impl

import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Book
import com.bookstore.app.mappers.AuthorMapper
import com.bookstore.app.mappers.BookCategoryMapper
import com.bookstore.app.mappers.BookMapper
import org.springframework.stereotype.Component

@Component
class BookMapperImpl(
    val authorMapper: AuthorMapper,
    val bookCategoryMapper: BookCategoryMapper
) : BookMapper {

    override fun toDto(book: Book): BookDto {
        if (book == null)
            return book

        val bookDto = BookDto()
        bookDto.apply {
            id = book.id
            name = book.name
            numberOfPages = book.numberOfPages
            author = authorMapper.toDto(book.author)
            quantity = book.quantity
            price = book.price
            category = bookCategoryMapper.toDto(book.category)
        }
        return bookDto
    }

    override fun toEntity(bookDto: BookDto): Book {
        val book = Book()
        book.apply {
            id = bookDto.id
            name = bookDto.name
            numberOfPages = bookDto.numberOfPages
            author = bookDto.author?.let { authorMapper.toEntity(it) }!!
            quantity = bookDto.quantity
            price = bookDto.price
            category = bookDto.category?.let { bookCategoryMapper.toEntity(it) }!!
        }
        return book
    }
}
