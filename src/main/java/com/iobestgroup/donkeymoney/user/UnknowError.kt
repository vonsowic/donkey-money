package com.iobestgroup.donkeymoney.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 09.01.18
 */
class UnknowError(statusCode: Int, message: String = "")
    : RuntimeException("Status code: $statusCode; Message: $message")