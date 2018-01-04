package com.iobestgroup.donkeymoney.user

import org.hibernate.validator.constraints.Email

import javax.persistence.*

@Entity
@Table(name = "users")
data class DMUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,


    @Email
    @Column(name = "username", unique = true)
    var email: String? = null,


    @Column(name = "password")
    var password: String = "",


    @Column(name = "securityToken")
    var securityToken: String = ""
)

