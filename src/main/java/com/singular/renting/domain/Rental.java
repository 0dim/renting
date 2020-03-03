package com.singular.renting.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "RENTAL")
public class Rental {

    private @Id @GeneratedValue Long id;

    private int days;
    private Date initialDate;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Film film;
}
