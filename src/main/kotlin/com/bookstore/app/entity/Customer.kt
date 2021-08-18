package com.bookstore.app.entity

import javax.persistence.*

@Table(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "username")
    var username: String,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String? = "",

    @Column(name = "last_name")
    var email: String
)
