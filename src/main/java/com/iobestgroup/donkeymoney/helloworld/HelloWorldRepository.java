package com.iobestgroup.donkeymoney.helloworld;

import org.springframework.data.repository.CrudRepository;

/**
 * @author miwas
 * @version 1.0
 * @since 21.10.17
 */
public interface HelloWorldRepository extends CrudRepository<HelloWorld, Long> {
}
