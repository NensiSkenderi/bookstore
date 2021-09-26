package com.bookstore.app.entity

import lombok.Data
import java.time.LocalDate
import java.time.LocalDateTime
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

    @Column(name = "first_name", nullable = false)
    val firstName: String = "",

    @Column(name = "last_name", nullable = true)
    val lastName: String? = "",

    @Column(name = "email", nullable = false)
    val email: String = "",

    @Column(name = "password", nullable = false, length = 60)
    var password: String = "",

    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)




