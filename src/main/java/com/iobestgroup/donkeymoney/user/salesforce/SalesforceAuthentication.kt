package com.iobestgroup.donkeymoney.user.salesforce

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 09.01.18
 */
data class SalesforceAuthentication(
        var access_token: String = "",
        var instance_url: String = "",
        var id: String = "",
        var token_type: String = "",
        var issued_at: String = "",
        var signature: String = ""
)