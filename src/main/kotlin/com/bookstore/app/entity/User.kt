package com.bookstore.app.entity

import javax.persistence.*

@Entity
@Table(name = "user")
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0,

    @Column(name = "email")
    var email: String = "",

    @Column(name = "username")
    var username: String = "",

    @Column(name = "password")
    open var passw: String = "",

    @Column(name = "first_name")
    var firstName: String = "",

    @Column(name = "last_name")
    var lastName: String? = "",

    var role: String = ""
)