package com.bookstore.app.entity

import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "number_of_pages")
    val numberOfPages: Int = 0,

    @Column(name = "quantity")
    val quantity: Int = 0,

    @Column(name = "price")
    val price: Double = 0.0
)
