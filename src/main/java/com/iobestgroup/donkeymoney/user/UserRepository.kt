package com.iobestgroup.donkeymoney.user

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<DMUser, Long> {

    fun findByEmail(userEmail: String): DMUser


    @Query("SELECT user FROM DMUser user WHERE username=:username AND password=:password")
    fun getSecurityToken(
            @Param("username") username: String,
            @Param("password") password: String
    ): DMUser
}
