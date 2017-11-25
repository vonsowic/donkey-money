package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import com.iobestgroup.donkeymoney.user.exceptions.UserDoesNotExistException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 24.11.17
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class UserServiceTest {

    @Autowired
    private UserService userDao;


    @Before
    public void save() throws Exception {
        DMUser user = new DMUser();
        user.setEmail("jarjar.binks@gmail.com");
        user.setLastName("Binks");
        user.setName("Jar Jar");
        user.setPassword("");
        user = userDao.save(user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }


    @Test(expected = UserAlreadyExistsException.class)
    public void insertUserWithEmailThatHasBeenAlreadyUsed() throws Exception {
        DMUser user = new DMUser();
        user.setEmail("jarjar.binks@gmail.com");
        user.setLastName("Binks");
        user.setName("Jar Jar");
        user.setPassword("");
        userDao.save(user);
    }


    @Test
    public void findByEmailTest() throws Exception {
        DMUser user = userDao.findByEmail("jarjar.binks@gmail.com");
        Assert.assertNotNull(user);
        Assert.assertEquals("Jar Jar", user.getName());
        Assert.assertEquals("Binks", user.getLastName());
    }


    @Test(expected = UserDoesNotExistException.class)
    public void searchByEmailButNotFindTest() throws Exception {
        userDao.findByEmail("jajar.binks@gmail.com");
    }


    @Test
    public void searchButNoResultDueToTooShortSearchQueryTest() throws Exception {
        assertThat(userDao.search("Ja")).hasSize(0);
    }

    @Test
    public void searchTest() throws Exception {
        assertThat(userDao.search("sol"))
                .hasSize(2);
    }
}