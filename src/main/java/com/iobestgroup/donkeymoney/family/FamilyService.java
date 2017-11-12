package com.iobestgroup.donkeymoney.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Service
public class FamilyService {

    private FamilyRepository dao;

    @Autowired
    public FamilyService(FamilyRepository dao) {
        this.dao = dao;
    }
}
