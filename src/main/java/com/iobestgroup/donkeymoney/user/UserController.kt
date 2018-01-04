package com.iobestgroup.donkeymoney.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(
        private val userDao: UserService
) {

    @PostMapping("/registration")
    fun signUp(@RequestBody user: DMUser) {
        userDao.save(user)
    }

    @PostMapping("/securityToken")
    fun getSecurityToken(email: String, password: String) = userDao
            .getSecurityToken(email, password)
}
