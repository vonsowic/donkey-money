package com.iobestgroup.donkeymoney.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.AssertFalse;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@RestController("/api/operation")
public class OperationController {

    private OperationService service;
    //@RequestHeader(SecurityConstants.HEADER_STRING) String token

    @Autowired
    public OperationController(OperationService service) {
        this.service = service;
    }
}
