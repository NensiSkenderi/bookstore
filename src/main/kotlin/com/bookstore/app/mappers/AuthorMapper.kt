package com.bookstore.app.mappers

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.entity.Author

interface AuthorMapper {
    fun toDto(author: Author): AuthorDto

    fun toEntity(authorDto: AuthorDto): Author
}
