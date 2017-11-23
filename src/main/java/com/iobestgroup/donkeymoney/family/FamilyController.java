package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.security.SecurityConstants;
import com.iobestgroup.donkeymoney.user.DMUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@RestController
@RequestMapping("/api/family")
public class FamilyController {

    private FamilyService familyDao;

    @Autowired
    public FamilyController(FamilyService familyDao) {
        this.familyDao = familyDao;
    }

    @PostMapping("/create")
    public void establishFamily(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestBody Family family){

    }

    @PostMapping("/add")
    public void produceFamilyMember(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestBody DMUser user,
            @RequestParam("id") Long familyId){

    }

    @GetMapping
    public Family getMyFamily(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long familyId){
        return null;
    }

    @GetMapping("/all")
    public Iterable<Family> getMyFamilies(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token){
        return null;
    }


    @DeleteMapping
    public void destroyFamily(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long id){

    }

    @PutMapping
    public void exileFamilyMember(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long userId){

    }

    @DeleteMapping("/leave")
    public void leaveFamily(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long familyId){

    }
}
