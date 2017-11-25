package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.user.DMUser;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 12.11.17
 */
@Data
@Entity(name = "families")
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String familyName;


    @Column(name = "members")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user",
            joinColumns = @JoinColumn(name = "id")
    )
    private Set<DMUser> familyMembers = new HashSet<>();


    public void addMember(DMUser member){
        getFamilyMembers().add(member);
    }

    public boolean exileMember(DMUser member){
        return getFamilyMembers().remove(member);
    }

    public Family removeEmails(){
        //  remove emails from response
        getFamilyMembers()
                .forEach(member -> member.setEmail(null));

        return this;
    }

}
