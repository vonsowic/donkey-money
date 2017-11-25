package com.iobestgroup.donkeymoney.operation;

import com.iobestgroup.donkeymoney.user.DMUser;
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
    @Column(name = "user_id")
    //DMUser user;
    Long userId;

    @Column(name = "family_id")
    Long familyId;


    @Column(name = "title")
    String title;


    @Column(name = "amount")
    Float amount;


    @Column(name = "datetime")
    Timestamp dateTime;

    //String category;
}
