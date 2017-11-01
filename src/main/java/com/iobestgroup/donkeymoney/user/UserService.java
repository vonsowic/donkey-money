package com.iobestgroup.donkeymoney.user;

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User potentialUser) throws UserAlreadyExistsException {
        if(!repository.findByEmail(potentialUser.getEmail()).isPresent()){
            return repository.save(potentialUser);
        }
        else {
            throw new UserAlreadyExistsException();
        }
    }
}
