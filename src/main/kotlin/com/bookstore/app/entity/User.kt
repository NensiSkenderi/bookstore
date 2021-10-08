package com.bookstore.app.entity

import javax.persistence.*

@Entity
@Table(name = "user")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id = 0

    @Column(name = "email")
    var email: String = ""

    @Column(name = "username")
    var username: String = ""

    @Column(name = "password")
    open var passw: String = ""

    @Column(name = "first_name")
    var firstName: String = ""

    @Column(name = "last_name")
    var lastName: String = ""

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: Set<Role>? = null

    constructor() {}
    constructor(user: User) {
        id = user.id
        email = user.email
        lastName = user.lastName
        username = user.username
        passw = user.passw
        roles = user.roles
        firstName = user.firstName
    }
}