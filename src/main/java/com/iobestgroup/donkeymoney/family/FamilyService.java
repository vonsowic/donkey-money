package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.family.exceptions.FamilyDoesNotExistsException;
import com.iobestgroup.donkeymoney.family.exceptions.NotMemberOfFamilyException;
import com.iobestgroup.donkeymoney.security.TokenDecoder;
import com.iobestgroup.donkeymoney.user.DMUser;
import com.iobestgroup.donkeymoney.user.UserRepository;
import com.iobestgroup.donkeymoney.user.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Service
public class FamilyService implements TokenDecoder.TokenToUser{

    private FamilyRepository familyDao;

    private UserRepository userDao;

    @Autowired
    public FamilyService(FamilyRepository familyDao, UserRepository userDao) {
        this.familyDao = familyDao;
        this.userDao = userDao;
    }


    public Family addUserToFamily(Long userId, Long familyId) {
        DMUser user = userDao.findOne(userId);
        if (user == null) throw new UserDoesNotExistException();

        Family family = findOne(familyId);

        family.addMember(user);
        return familyDao.save(family);
    }

    /**
     *
     * @param family
     * @param founder user who created family.
     * @return saved family with id and one user who created it.
     */
    public Family createFamily(Family family, DMUser founder){
        Family createdFamily = familyDao.save(family);
        createdFamily.addMember(founder);
        return familyDao.save(createdFamily);
    }


    public Family createFamily(Family family, String foundersToken){
        return createFamily(family, getUser(foundersToken, userDao));
    }


    public void leaveFamily(Long familyId, String token) {
        leaveFamily(familyId, getUser(token, userDao));
    }

    public Family leaveFamily(Long familyId, DMUser user) {
        Family family = findOne(familyId);
        if(!family.exileMember(user)){
            throw new NotMemberOfFamilyException();
        }
        return familyDao.save(family);
    }


    private Family findOne(Long familyId){
        Family family = familyDao.findOne(familyId);
        if (family == null) throw new FamilyDoesNotExistsException();

        return family;
    }


    public Family findMyFamily(Long familyId, String token) {
        return findMyFamily(familyId, getUser(token, userDao).getId());
    }

    public Family findMyFamily(Long familyId, Long userId) {
        final Family family = familyDao.findOne(familyId);
        for(DMUser member : family.getFamilyMembers()){
            if(member.getId().equals(userId)){
                return family;
            }
        }

        // all members of family have been checked; you are not one of them
        throw new NotMemberOfFamilyException();
    }

    public Iterable<Family> findAllMyFamilies(String token) {
        return findAllMyFamilies(getUser(token, userDao));
    }

    public Iterable<Family> findAllMyFamilies(DMUser user) {
        return StreamSupport.stream(familyDao.findAll().spliterator(), false)
                .filter(family -> family.getFamilyMembers().contains(user))
                .collect(Collectors.toList());
    }

    /**
     * @param search - must have at least 3 characters
     * @return empty list if search has less than 3 characters
     */
    public Iterable<Family> search(String search) {
        if (search.length() < 3) return new ArrayList<>();
        return familyDao.search(search.toLowerCase() + '%');
    }
}
