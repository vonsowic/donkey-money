package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.security.SecurityConstants;
import com.iobestgroup.donkeymoney.security.TokenDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

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

    //@RequestHeader(SecurityConstants.HEADER_STRING) String token

    @PostMapping("/registration")
    public void signUp(@RequestBody DMUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @GetMapping
    public DMUser getUserInfo(@RequestHeader(SecurityConstants.HEADER_STRING) String token){
        return userDao.findByEmail(TokenDecoder.getSubject(token));
    }

    @GetMapping("/all")
    public Iterable<DMUser> getAllUsers(@RequestHeader(SecurityConstants.HEADER_STRING) String token){
        return userDao.findAll();
    }
}
