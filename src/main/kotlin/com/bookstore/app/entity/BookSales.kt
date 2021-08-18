package com.bookstore.app.entity

import javax.persistence.*


@Table(name = "book_sales")
data class BookSales(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int,

    @Column(name = "unit_sales_price")
    var unitSalesPrice: Int,

    @Column(name = "customer")
    var customer: Customer,
)
