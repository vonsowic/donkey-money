package com.iobestgroup.donkeymoney.user.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 04.01.18
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "not authorized")
class UserNotAuthorizedException : RuntimeException()