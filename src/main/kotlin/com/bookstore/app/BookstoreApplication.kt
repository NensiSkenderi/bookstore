package com.bookstore.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder




@SpringBootApplication
@EnableAutoConfiguration
class BookstoreApplication

fun main(args: Array<String>) {
    SpringApplication.run(BookstoreApplication::class.java, *args)

    val passwordEncoder = BCryptPasswordEncoder()
    val password = "secret"
    val encodedPassword = passwordEncoder.encode(password)

    println();
    println("Password is         : " + password);
    println("Encoded Password is : " + encodedPassword);
    println();

    val isPasswordMatch = passwordEncoder.matches(password, encodedPassword)
    println("Password : $password   isPasswordMatch    : $isPasswordMatch")
}
