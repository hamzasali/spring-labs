package com.cydeo.lab06orm.Entity;


import com.cydeo.lab06orm.u.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

}
