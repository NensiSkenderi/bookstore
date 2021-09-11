package com.bookstore.app.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
data class Book(
    // A bean always requires a default constructor
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
    var price: Double,

    @ManyToOne
    @JoinColumn(name = "book_category_id")
    var category: BookCategory,

    @ManyToOne
    @JoinColumn(name = "author_id")
    var author: Author

) {
    constructor() : this(
        0, "", 0, 0, 0.0,
        BookCategory(), Author()
    ) {
        // this is an empty constructor
    }
}
