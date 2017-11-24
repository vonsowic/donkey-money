package com.iobestgroup.donkeymoney.user;

import com.google.common.collect.Streams;
import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * @param potentialUser
     * @return potentialUser with id.
     * @throws UserAlreadyExistsException
     */
    public DMUser save(DMUser potentialUser) throws UserAlreadyExistsException {
        try {
            return repository.save(potentialUser);
        } catch (DataIntegrityViolationException e){
            throw new UserAlreadyExistsException();
        }
    }

    public DMUser findByEmail(String email){
        return repository.findByEmail(email);
    }

    /**
     * @return all users without theirs emails
     */
    public Iterable<DMUser> findAll(){
        return Streams.stream(repository.findAll())
                .peek(it -> it.setEmail(null))
                .collect(Collectors.toList());
    }
}
