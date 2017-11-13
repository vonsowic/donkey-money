package com.iobestgroup.donkeymoney.security.token;

import com.iobestgroup.donkeymoney.user.DMUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 13.11.17
 */
public interface TokenRepository extends CrudRepository<Token, DMUser>{
}
