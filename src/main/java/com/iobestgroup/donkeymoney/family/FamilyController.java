package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.security.SecurityConstants;
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

        familyDao.createFamily(family, token);
    }


    @PostMapping("/add")
    public void produceFamilyMember(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("user_id") Long userId,
            @RequestParam("family_id") Long familyId){

        familyDao.addUserToFamily(userId, familyId);
    }


    @GetMapping("/my")
    public Family getMyFamily(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long familyId){
        return familyDao.findMyFamily(familyId, token);
    }


    @GetMapping("/all")
    public Iterable<Family> getMyFamilies(@RequestHeader(SecurityConstants.HEADER_STRING) String token) {
        return familyDao.findAllMyFamilies(token);
    }


    @DeleteMapping
    public void leaveFamily(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("id") Long familyId){

                // FIXME: Invalid CORS request
        familyDao.leaveFamily(familyId, token);
    }


    @GetMapping
    public Iterable<Family> getUserInfo(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("search") String search){

        return familyDao.search(search);
    }
}
