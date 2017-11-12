package com.iobestgroup.donkeymoney.operation;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
public interface OperationRepository extends CrudRepository<Operation, Long> {
}
