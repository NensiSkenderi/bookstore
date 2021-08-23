package com.bookstore.app.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
data class Customer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "username")
    val username: String = "",

    @Column(name = "first_name")
    val firstName: String = "",

    @Column(name = "last_name")
    val lastName: String? = "",

    @Column(name = "email")
    val email: String = ""
)

@Entity
class OrderEntity(
    var firstName: String = "",
    var lastName: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "order")
    private val _lineItems = mutableListOf<LineItem>()

    val lineItems get() = _lineItems.toList()

    fun addLineItem(newItem: LineItem) {
        _lineItems += newItem // ".this" can be omitted too
    }
}

@Entity
class LineItem(
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    val order: OrderEntity? = null
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}