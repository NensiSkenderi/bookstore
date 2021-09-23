package com.bookstore.app.service.impl

import com.bookstore.app.dto.UserDto
import com.bookstore.app.entity.User
import com.bookstore.app.repository.UserRepository
import com.bookstore.app.service.UserService
import org.springframework.beans.factory.annotation.Autowired
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

    override fun addUser(userDto: UserDto, isUserAdmin: Int): String {
        val userExists: Boolean = userRepository.existsUserByUsername(username = userDto.username)
        if (userExists)
            return "User already exists!"
        userDto.copy(isAdmin = isUserAdmin)
        val user = userDto.toUserEntity()
        user.apply {
            this.password = BCryptPasswordEncoder().encode(userDto.password)
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
        val user = userRepository.findUserByUsername(username)
        return user.toUserDto()
    }

    private fun User.toUserDto() = UserDto(
        id = id,
        username = username,
        firstName = firstName,
        lastName = lastName,
        email = email,
        role = role,
        isAdmin = isAdmin,
        password = password
    )

    private fun UserDto.toUserEntity() = User(
        id = id,
        username = username,
        firstName = firstName,
        lastName = lastName,
        email = email,
        role = role,
        isAdmin = isAdmin,
        password = password
    )
}
