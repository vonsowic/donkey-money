package com.iobestgroup.donkeymoney.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<DMUser, Long> {
    DMUser findByName(String userName);
    DMUser findByEmail(String userEmail);

}
