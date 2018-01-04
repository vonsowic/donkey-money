package com.iobestgroup.donkeymoney.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(
        private val userDao: UserService,
        private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {

    @PostMapping("/registration")
    fun signUp(@RequestBody user: DMUser) {
        user.password = bCryptPasswordEncoder.encode(user.password)
        userDao.save(user)
    }

    @PostMapping("/securityToken")
    fun getSecurityToken(email: String, password: String) = userDao
            .getSecurityToken(email, bCryptPasswordEncoder.encode(password))
}
