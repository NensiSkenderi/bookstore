package com.bookstore.app.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "book_category")
@AllArgsConstructor
@NoArgsConstructor
data class BookCategory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "name")
    var name: String,

    @OneToMany(mappedBy = "category")
    var book: List<Book> = listOf()
) {
    constructor() : this(0, "")
}
