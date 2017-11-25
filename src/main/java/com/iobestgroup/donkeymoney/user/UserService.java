package com.iobestgroup.donkeymoney.user;

import com.google.common.collect.Streams;
import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import com.iobestgroup.donkeymoney.user.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userDao;

    @Autowired
    public UserService(UserRepository repository) {
        this.userDao = repository;
    }

    /**
     * @param potentialUser
     * @return potentialUser with id.
     * @throws UserAlreadyExistsException
     */
    public DMUser save(DMUser potentialUser) throws UserAlreadyExistsException {
        try {
            return userDao.save(potentialUser);
        } catch (DataIntegrityViolationException e){
            throw new UserAlreadyExistsException();
        }
    }

    public DMUser findByEmail(String email){
        DMUser user = userDao.findByEmail(email);
        if (user == null) throw new UserDoesNotExistException();
        return user;
    }

    /**
     * @return all users without theirs emails
     */
    public Iterable<DMUser> findAll(){
        return Streams.stream(userDao.findAll())
                .peek(it -> it.setEmail(null))
                .collect(Collectors.toList());
    }

    /**
     * @param search - must have at least 3 characters
     * @return empty list if search has less than 3 characters
     */
    public Iterable<DMUser> search(String search) {
        if (search.length() < 3) return new ArrayList<>();
        return userDao.search(search.toLowerCase() + '%');
    }
}
