package com.iobestgroup.donkeymoney.operation;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Data
@Entity
@Table(name = "operations")
public class Operation {

    @Id
    //@OneToMany
    Long userId;


    Long familyId;


    String title;


    Float amount;


    Timestamp dateTime;


    String category;
}
