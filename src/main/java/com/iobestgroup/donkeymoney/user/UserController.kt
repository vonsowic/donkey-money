package com.iobestgroup.donkeymoney.user

import com.iobestgroup.donkeymoney.user.salesforce.SalesforceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(
        private val userDao: UserService,
        private val salesforce: SalesforceService
) {

    @CrossOrigin(origins = ["https://donkeymoney-app.herokuapp.com"])
    @PostMapping("/securityToken")
    fun getSecurityToken(@RequestBody user: DMUser) = userDao
            .getSecurityToken(
                    user.email,
                    user.password
            )

    @CrossOrigin(origins = ["https://donkeymoney-app.herokuapp.com"])
    @PostMapping("/registration")
    fun signUp(@RequestBody user: DMUser) {
        salesforce.createUser(user)
        userDao.save(user)
    }


    @CrossOrigin(origins = ["https://donkeymoney-app.herokuapp.com"])
    @PutMapping("/registration")
    fun confirmAndSaveSalesforceSecurityToken(@RequestBody user: DMUser) {
        userDao.update(user)
    }
}
