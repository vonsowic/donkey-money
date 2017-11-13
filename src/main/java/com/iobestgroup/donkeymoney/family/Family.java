package com.iobestgroup.donkeymoney.family;

import com.iobestgroup.donkeymoney.user.DMUser;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    String familyName;

    //List<DMUser> familyMembers;
}
