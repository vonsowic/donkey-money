package com.iobestgroup.donkeymoney.user.salesforce

import com.google.gson.Gson
import com.iobestgroup.donkeymoney.user.DMUser
import com.mashape.unirest.http.Unirest.post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 09.01.18
 */
@Service
class SalesforceService @Autowired constructor(){


    private val salesforceToken
        get() =
            Gson().fromJson(
                    post("https://donkeymoney-dev-ed.my.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9I5UQ_0k_hTmeUVaC9dV..7VgXlT69Oraw3ycdvmAmmiykCsDVWLaJFImgV6lJi2M6BhU8Y0mQvA7WINR&client_secret=6219607681359612175&username=donkeymoney@polsource.com&password=%23e8a5u39RQyPO9Q712dpVwYul1lMmECOo")
                            .asJson()
                            .body
                            .toString(),
                    SalesforceAuthentication::class.java)



    fun createUser(user: DMUser) {
        val token = salesforceToken
        post("https://donkeymoney-dev-ed.my.salesforce.com/services/apexrest/user/registration")
                .header("Authorization", "${token.token_type} ${token.access_token}")
                .header("charset", "UTF-8")
                .field("email", user.email)
                .field("password", user.password)
                .field("name", user.name)
                .field("lastName", user.lastName)
                .asJson()
    }
}