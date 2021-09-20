package com.bookstore.app.config.security

import com.bookstore.app.dto.UserDto
import com.bookstore.app.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDetailsServiceImpl: UserDetailsService {

    @Autowired
    private lateinit var userService: UserService

    override fun loadUserByUsername(username: String): UserDetails {
        val userDto = userService.getUserByUsername(username)
        val authority: GrantedAuthority = SimpleGrantedAuthority(userDto.role)
        return User(userDto.username, userDto.password, listOf(authority))
    }
}