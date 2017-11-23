package com.iobestgroup.donkeymoney.operation;

import com.iobestgroup.donkeymoney.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.AssertFalse;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@RestController
@RequestMapping("/api/operation")
public class OperationController {

    private OperationService service;

    @Autowired
    public OperationController(OperationService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public void addOperation(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestBody Operation operation){

    }

    @GetMapping("/many")
    public Iterable<Operation> getOperations(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("limit") int limit,
            @RequestParam(name = "limit", defaultValue = "0", required = false) int offset
    ){
        return null;
    }

    @GetMapping
    public Operation getOperation(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long id){
        return null;
    }

    @PutMapping
    public void updateOperation(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestBody Operation operation){

    }

    @DeleteMapping
    public void deleteOperation(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long id){

    }
}
