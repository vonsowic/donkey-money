package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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
        userDao.save(user);
    }


    @GetMapping("/registration")
    public String getRegistrationPage(){

        return "path to registration page";
    }

    @PostMapping("/login")
    public String login(){

        return "redirect:/";
    }


    @GetMapping("/login")
    public String getLoginPage(){

        return "path to login page";
    }
}
