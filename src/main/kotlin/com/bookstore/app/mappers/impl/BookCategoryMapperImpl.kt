
package com.bookstore.app.mappers.impl

import com.bookstore.app.dto.BookCategoryDto
import com.bookstore.app.entity.BookCategory
import com.bookstore.app.mappers.BookCategoryMapper
import org.springframework.stereotype.Component

@Component
class BookCategoryMapperImpl : BookCategoryMapper {

    override fun toDto(bookCategory: BookCategory): BookCategoryDto {
        if (bookCategory == null) {
            return BookCategoryDto()
        }

        val bookCategoryDto = BookCategoryDto()
        bookCategoryDto.apply {
            id = bookCategory.id
            name = bookCategory.name
        }
        return bookCategoryDto
    }

    override fun toEntity(bookCategoryDto: BookCategoryDto): BookCategory {
        val bookCategory = BookCategory()
        bookCategory.apply {
            id = bookCategoryDto.id
            name = bookCategoryDto.name
        }
        return bookCategory
    }
}
