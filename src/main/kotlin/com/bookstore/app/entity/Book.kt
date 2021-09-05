package com.bookstore.app.entity

import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "number_of_pages")
    val numberOfPages: Int,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "price")
    val price: Double
)
