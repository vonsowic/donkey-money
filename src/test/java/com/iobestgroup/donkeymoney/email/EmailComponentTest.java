package com.iobestgroup.donkeymoney.email;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 24.11.17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailComponentTest {

    @Autowired EmailComponent emailComponent;

    @Test
    public void sendSimpleMessage() throws Exception{
        emailComponent.sendSimpleMessage(
                "donkeymoneyapp@gmail.com",
                "Do not respond",
                "This is test running at " + new Date().toString());
    }

}