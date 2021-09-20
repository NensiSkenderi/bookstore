package com.bookstore.app.entity

import lombok.Data
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user")
@Data
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "username", nullable = false)
    val username: String = "",

    @Column(name = "first_name")
    val firstName: String = "",

    @Column(name = "last_name")
    val lastName: String? = "",

    @Column(name = "email", nullable = false)
    val email: String = "",

    @Column(name = "password", nullable = false, length = 60)
    val password: String = "",

    @Column(name = "role", nullable = false, length = 60)
    val role: String = "",

    @Column(name = "is_admin", nullable = false)
    val isAdmin: Boolean = false,

    @Column(name = "created_at")
    val createdAt: LocalDate = LocalDate.now()
)
