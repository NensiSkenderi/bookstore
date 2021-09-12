
package com.bookstore.app.mappers.impl

import com.bookstore.app.dto.AuthorDto
import com.bookstore.app.entity.Author
import com.bookstore.app.mappers.AuthorMapper
import org.springframework.stereotype.Component

@Component
class AuthorMapperImpl : AuthorMapper {

    override fun toDto(author: Author): AuthorDto {
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

    override fun toEntity(authorDto: AuthorDto): Author {
        val author = Author()
        author.apply {
            id = authorDto.id
            firstName = authorDto.firstName
            lastName = authorDto.lastName
        }
        return author
    }
}
