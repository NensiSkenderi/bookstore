package com.bookstore.app.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
data class Customer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "username")
    val username: String = "",

    @Column(name = "first_name")
    val firstName: String = "",

    @Column(name = "last_name")
    val lastName: String? = "",

    @Column(name = "email")
    val email: String = ""
)
