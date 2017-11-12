package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(UserRepository service,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = service;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/registration")
    public void signUp(@RequestBody DMUser user) throws UserAlreadyExistsException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userDao.save(user);

        System.out.println("Registration");
        System.out.println(user.getName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }
}
