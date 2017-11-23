package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.user.DMUser;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Data
@Entity
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    String familyName;


    @Column(name = "members")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user",
            joinColumns = @JoinColumn(name = "id")
    )
    private List<DMUser> familyMembers;

}
