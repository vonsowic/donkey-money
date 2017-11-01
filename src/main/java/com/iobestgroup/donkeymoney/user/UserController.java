package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userDao;

    @Autowired
    public UserController(UserService service) {
        this.userDao = service;
    }


    @PostMapping("/registration")
    public String register(
            @RequestParam("name")       String name,
            @RequestParam("last_name")  String lastName,
            @RequestParam("email")      String email
    ) throws UserAlreadyExistsException {
        User potentialUser = new User();
        potentialUser.setName(name);
        potentialUser.setLastName(lastName);
        potentialUser.setEmail(email);

        userDao.save(potentialUser);

        return "redirect:/";
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
