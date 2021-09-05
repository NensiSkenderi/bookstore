package com.bookstore.app.dto.mapper

import com.bookstore.app.dto.dao.BookDto
import com.bookstore.app.entity.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.modelmapper.ModelMapper;

@Component
class BookMapper {

    @Autowired
    private lateinit var modelMapper: ModelMapper

    private fun convertToDto(book: Book): BookDto{
        return modelMapper.map(book, BookDto::class.java)
    }

    private fun convertToEntity(bookDto: BookDto): Book{
        return modelMapper.map(bookDto, Book::class.java)
    }

}