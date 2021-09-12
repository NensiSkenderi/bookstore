package com.bookstore.app.mappers

import com.bookstore.app.dto.BookCategoryDto
import com.bookstore.app.entity.BookCategory

interface BookCategoryMapper {
    fun toDto(bookCategory: BookCategory): BookCategoryDto

    fun toEntity(bookCategoryDto: BookCategoryDto): BookCategory
}
