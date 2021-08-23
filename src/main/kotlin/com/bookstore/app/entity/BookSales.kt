package com.bookstore.app.entity

import javax.persistence.*

@Entity
@Table(name = "book_sales")
data class BookSales(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = 0,

    @Column(name = "unit_sales_price")
    val unitSalesPrice: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    val order: Customer? = null
)
