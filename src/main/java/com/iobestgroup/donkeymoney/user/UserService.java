package com.iobestgroup.donkeymoney.user;

import com.google.common.collect.Streams;
import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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
        return userDao.findByEmail(email);
    }

    /**
     * @return all users without theirs emails
     */
    public Iterable<DMUser> findAll(){
        return Streams.stream(userDao.findAll())
                .peek(it -> it.setEmail(null))
                .collect(Collectors.toList());
    }

    public Iterable<DMUser> search(String search) {
        return userDao.search(search.toLowerCase() + '%');
    }
}
