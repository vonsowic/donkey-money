package com.iobestgroup.donkeymoney.adminpanel

import com.iobestgroup.donkeymoney.user.salesforce.SalesforceService
import com.iobestgroup.donkeymoney.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 09.01.18
 */
@RestController
@RequestMapping("/api/adminhubabuba")
class AdminController @Autowired constructor(
        private val userDao: UserService,
        private val salesforce: SalesforceService
) {


    @GetMapping("/all")
    fun findAll() = userDao.findAll()

    @DeleteMapping("/deleteAll")
    fun deleteAllUsers() = userDao.deleteAll()
}
