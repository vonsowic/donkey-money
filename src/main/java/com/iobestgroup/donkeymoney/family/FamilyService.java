package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.user.DMUser;
import com.iobestgroup.donkeymoney.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Service
public class FamilyService {

    private FamilyRepository familyDao;

    private UserRepository userDao;

    @Autowired
    public FamilyService(FamilyRepository familyDao, UserRepository userDao) {
        this.familyDao = familyDao;
        this.userDao = userDao;
    }

    public void addUserToFamily(Long userId, Long familyId) {
        DMUser user = userDao.findOne(userId);
        Family family = familyDao.findOne(familyId);
        family.getFamilyMembers().add(user);
        familyDao.save(family);
    }
}
