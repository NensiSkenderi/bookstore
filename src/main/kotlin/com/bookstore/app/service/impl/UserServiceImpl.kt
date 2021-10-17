package com.bookstore.app.service.impl

import com.bookstore.app.dto.UserDto
import com.bookstore.app.entity.ApplicationUserRole
import com.bookstore.app.entity.User
import com.bookstore.app.repository.UserRepository
import com.bookstore.app.service.UserService
import com.bookstore.app.utils.Helper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getUserById(userId: Int): UserDto {
        val user = userRepository.findById(userId).get()
        return user.toUserDto()
    }

    override fun addUser(userDto: UserDto): String {
        val userExists: Boolean = userRepository.existsUserByUsername(username = userDto.username)
        if (userExists)
            return "User already exists!"
        if(!Helper.isAdmin())
            userDto.role = ApplicationUserRole.USER.name
        val user = userDto.toUserEntity()
        user.apply {
            this.passw = BCryptPasswordEncoder().encode(userDto.password)
        }
        userRepository.save(user)
        return "User added successfully!"
    }

    override fun deleteUserById(userId: Int): String {
        val exists: Boolean = userRepository.existsById(userId)
        return if (exists) {
            userRepository.deleteById(userId)
            "User deleted successfully!"
        } else
            "User does not exists!"
    }

    override fun getUserByUsername(username: String): UserDto {
        return userRepository.findByUsername(username).toUserDto()
    }

    private fun User.toUserDto() = UserDto(
        id = id,
        username = username,
        firstName = firstName,
        lastName = lastName,
        email = email,
        password = passw,
        role = role
    )

    private fun UserDto.toUserEntity() = User(
        id = id,
        username = username,
        email = email,
        passw = password,
        firstName = firstName,
        lastName = lastName,
        role = role
    )
}
