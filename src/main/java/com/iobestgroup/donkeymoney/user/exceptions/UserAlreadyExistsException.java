package com.iobestgroup.donkeymoney.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 13.11.17
 */
@ResponseStatus(value= HttpStatus.CONFLICT, reason="User with this email already exists")
public class UserAlreadyExistsException extends RuntimeException {}
