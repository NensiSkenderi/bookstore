package com.bookstore.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
open class BookstoreApplication

fun main(args: Array<String>) {
	runApplication<BookstoreApplication>(*args)
}
