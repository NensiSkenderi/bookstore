
package com.bookstore.app.mappers.impl

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.dto.BookDto
import com.bookstore.app.entity.Author
import com.bookstore.app.entity.Book
import com.bookstore.app.mappers.AuthorMapper
import com.bookstore.app.mappers.BookMapper
import org.springframework.stereotype.Component

@Component
class AuthorMapperImpl : AuthorMapper {

    override fun authorToAuthorDto(author: Author): AuthorDto {
        if (author == null) {
            return AuthorDto()
        }

        val authorDto = AuthorDto()
        authorDto.apply {
            id = author.id
            firstName = author.firstName
            lastName = author.lastName
        }
        return authorDto
    }

    override fun authorDtoToAuthor(authorDto: AuthorDto): Author {
        if (authorDto == null) {
            return authorDto
        }

        val author = Author()
        author.apply {
            id = authorDto.id
            firstName = authorDto.firstName
            lastName = authorDto.lastName
        }
        return author
    }

}
