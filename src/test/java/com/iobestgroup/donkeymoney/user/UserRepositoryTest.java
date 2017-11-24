package com.iobestgroup.donkeymoney.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 24.11.17
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userDao;

    @Test
    public void findByEmailTest() throws Exception {
        DMUser user = userDao.findByEmail("han.solo@gmail.com");
        Assert.assertNotNull(user);
        Assert.assertEquals("Han", user.getName());
        Assert.assertEquals("Solo", user.getLastName());
    }

    @Test
    public void searchTest() throws Exception {
        Iterable<DMUser> users = userDao.search("solo");
        assertThat(users)
                .hasSize(2);
    }

    @Test
    public void findByEmailButNotFindTest() throws Exception {
        DMUser user = userDao.findByEmail("hansolo@gmail.com");
        Assert.assertNull(user);
    }

}