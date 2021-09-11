package com.bookstore.app.entity

import lombok.Data
import javax.persistence.*

@Entity
@Table(name = "author")
@Data
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0,

    @Column(name = "first_name")
    var firstName: String = "",

    @Column(name = "last_name")
    var lastName: String = "",

    @OneToMany(mappedBy = "author")
    val book: List<Book> = listOf()

) {
    fun getFullName(): String {
        return "$firstName $lastName"
    }
}
