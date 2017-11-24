package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.email.EmailComponent;
import com.iobestgroup.donkeymoney.security.SecurityConstants;
import com.iobestgroup.donkeymoney.security.TokenDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userDao;
    private final EmailComponent email;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserController(UserService service,
                          EmailComponent email, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = service;
        this.email = email;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/registration")
    public void signUp(@RequestBody DMUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userDao.save(user);
        
        email.sendSimpleMessage(
                user.getEmail(),
                "Greetings",
                "Hello " + user.getName() + ", \nwelcome message and potential token to authanticate email owner."
        );
    }


    @GetMapping("/me")
    public DMUser getUserInfo(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token){
        return userDao.findByEmail(TokenDecoder.getSubject(token));
    }


    @GetMapping
    public Iterable<DMUser> getUserInfo(
            @RequestHeader(SecurityConstants.HEADER_STRING) String token,
            @RequestParam("search") String search){

        return userDao.search(search);
    }
}
