package com.iobestgroup.donkeymoney.user;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class DMUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;
}
