package com.bookstore.app.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
data class Book(
    //A bean always requires a default constructor
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