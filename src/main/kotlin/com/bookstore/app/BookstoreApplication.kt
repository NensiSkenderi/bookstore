package com.bookstore.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableAutoConfiguration
class BookstoreApplication

fun main(args: Array<String>) {
    SpringApplication.run(BookstoreApplication::class.java, *args)
}
