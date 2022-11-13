package com.cydeo.lab06orm.Entity;


import com.cydeo.lab06orm.u.BaseEntity;
import com.cydeo.lab06orm.u.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity {
    private BigDecimal amount;

    @OneToOne
    private Customer customer;
}
