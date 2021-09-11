package com.bookstore.app.mappers

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.entity.Author

interface AuthorMapper {
    fun authorToAuthorDto(author: Author): AuthorDto

    fun authorDtoToAuthor(authorDto: AuthorDto): Author
}
