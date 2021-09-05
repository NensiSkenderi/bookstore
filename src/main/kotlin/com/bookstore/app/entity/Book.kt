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
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "number_of_pages")
    val numberOfPages: Int,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "price")
    val price: Double

) {
    constructor() : this(0,"", 0, 0, 0.0) {
        //this is an empty constructor
    }
}