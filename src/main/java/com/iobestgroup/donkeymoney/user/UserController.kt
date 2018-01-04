package com.iobestgroup.donkeymoney.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(
        private val userDao: UserService
) {

    @CrossOrigin(origins = ["https://donkeymoney-app.herokuapp.com"])
    @PostMapping("/registration")
    fun signUp(@RequestBody user: DMUser) {
        userDao.save(user)
    }

    @CrossOrigin(origins = ["https://donkeymoney-app.herokuapp.com"])
    @PostMapping("/securityToken")
    fun getSecurityToken(@RequestBody user: DMUser) = userDao
            .getSecurityToken(
                    user.email,
                    user.password
            )

    @GetMapping("/all")
    fun findAll() = userDao.findAll()
}
