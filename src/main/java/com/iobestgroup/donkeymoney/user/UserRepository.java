package com.iobestgroup.donkeymoney.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<DMUser, Long> {
    DMUser findByName(String userName);
    DMUser findByEmail(String userEmail);

    @Query("select user from users user where lower(name) like :search or lower(last_name) like :search")
    Iterable<DMUser> search(@Param("search") String search);
}
