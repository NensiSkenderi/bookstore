package com.bookstore.app.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "first_name")
    val firstName: String = "",

    @Column(name = "last_name")
    val lastName: String = "",

    @OneToMany(mappedBy = "author")
    val book: List<Book> = listOf()

) {
    fun getFullName(): String{
        return "$firstName $lastName"
    }
}
