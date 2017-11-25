package com.iobestgroup.donkeymoney.family.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 24.11.17
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="There is no such family")
public class FamilyDoesNotExistsException extends RuntimeException {}
