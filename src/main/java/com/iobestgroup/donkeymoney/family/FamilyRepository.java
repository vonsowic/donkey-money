package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.user.DMUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Repository
public interface FamilyRepository extends CrudRepository<Family, Long>{

    @Query("select family from families family where lower(name) like :search")
    Iterable<Family> search(@Param("search") String search);

    // FIXME
    //@Query("select f from families f where ANY(select members from families where )")
    //Iterable<Family> findAll(@Param("user_id") DMUser userId);
}
