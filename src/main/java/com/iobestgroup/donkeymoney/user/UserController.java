package com.iobestgroup.donkeymoney.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(UserService service,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = service;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/registration")
    public void signUp(@RequestBody DMUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
}
