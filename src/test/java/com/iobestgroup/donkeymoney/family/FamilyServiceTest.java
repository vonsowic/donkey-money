package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.family.exceptions.FamilyDoesNotExistsException;
import com.iobestgroup.donkeymoney.user.DMUser;
import com.iobestgroup.donkeymoney.user.exceptions.UserDoesNotExistException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 24.11.17
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class FamilyServiceTest {

    @Autowired
    private FamilyService familyDao;

    @Before
    public void createFamily() throws Exception {
        DMUser founder = new DMUser();
        founder.setId(1L);

        Family family = new Family();
        family.setFamilyName("Bestfamilyever");
        family = familyDao.createFamily(family, founder);

        Assert.assertNotNull(family);
        Assert.assertNotNull(family.getId());
        assertThat(family.getFamilyMembers())
                .hasSize(1)
                .contains(founder);
    }

    @Test
    public void addUserToFamily() throws Exception {
        Family family = familyDao.addUserToFamily(1L, 1L);
        Assert.assertNotNull(family);
        assertThat(family.getFamilyMembers()).hasSize(1);
        Assert.assertEquals("DonkeyMoneyFamily", family.getFamilyName());
    }

    @Test(expected = FamilyDoesNotExistsException.class)
    public void addUserToNotExistingFamily() throws Exception {
        Family family = familyDao.addUserToFamily(1L, 1121212L);
    }

    @Test(expected = UserDoesNotExistException.class)
    public void addNotExistingUserToFamily() throws Exception {
        Family family = familyDao.addUserToFamily(19999999999999999L, 1L);
    }


    @Test
    public void leaveFamily() throws Exception {
        // TODO
    }


    @Test
    public void findMyFamily() throws Exception {
        familyDao.addUserToFamily(1L, 1L);
        Family family = familyDao.findMyFamily(1L, 1L);
        Assert.assertNotNull(family);
        Assert.assertEquals("DonkeyMoneyFamily", family.getFamilyName());
    }


    @Test
    public void findAllUsersFamilies() throws Exception {
        DMUser user = new DMUser();
        user.setId(1L);
        assertThat(familyDao.findAllMyFamilies(user))
                .hasSize(1);

    }


    @Test
    public void search() throws Exception {
        Iterable<Family> families = familyDao.search("fam");
        assertThat(families)
                .hasSize(3);
    }

    @Test
    public void searchButGetEmptyResultBecauseSearchStringIsTooShort() throws Exception {
        Iterable<Family> families = familyDao.search("fa");
        assertThat(families)
                .hasSize(0);
    }

}