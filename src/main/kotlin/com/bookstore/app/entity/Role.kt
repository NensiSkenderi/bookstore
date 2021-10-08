package com.bookstore.app.entity

import javax.persistence.*

@Entity
@Table(name = "role")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    var roleId = 0

    @Column(name = "role")
    var role: String? = null
}