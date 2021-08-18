package com.bookstore.app.entity

import javax.persistence.*


@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "name")
    var name: String,

    @Column(name = "number_of_pages")
    var numberOfPages: Int,

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "price")
    var price: Double
)
