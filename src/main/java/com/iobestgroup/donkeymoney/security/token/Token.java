package com.iobestgroup.donkeymoney.security.token;

import com.iobestgroup.donkeymoney.user.DMUser;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 13.11.17
 */
@Entity
@Table(name = "tokens")
public class Token implements Serializable{

    @Id
    //@OneToOne(mappedBy="txn")
    //@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    DMUser user;

    @Column(name = "token")
    String token;

    @Column(name = "expiration_date")
    Timestamp tokenExpirationDate;

    @Column(name = "refresh_token")
    String refreshToken;


}
