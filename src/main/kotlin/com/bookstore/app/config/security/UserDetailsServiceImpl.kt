package com.bookstore.app.config.security

import com.bookstore.app.entity.CustomUserDetails
import com.bookstore.app.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
class UserDetailsServiceImpl(private val usersRepository: UserRepository) : UserDetailsService {

   @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = usersRepository.findByUsername(username)
        return CustomUserDetails(user);
    }

}