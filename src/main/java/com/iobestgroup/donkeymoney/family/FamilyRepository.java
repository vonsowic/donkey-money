package com.iobestgroup.donkeymoney.family;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Repository
public interface FamilyRepository extends CrudRepository<Family, Long>{
}
