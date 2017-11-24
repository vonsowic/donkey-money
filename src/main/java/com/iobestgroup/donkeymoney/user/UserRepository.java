package com.iobestgroup.donkeymoney.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<DMUser, Long> {

    DMUser findByEmail(String userEmail);

    /**
     * @param search - should be lowercase and with % at the end.
     * @return users, with names or last names staring with search string.
     */
    @Query("select user from users user where lower(name) like :search or lower(last_name) like :search")
    Iterable<DMUser> search(@Param("search") String search);
}
