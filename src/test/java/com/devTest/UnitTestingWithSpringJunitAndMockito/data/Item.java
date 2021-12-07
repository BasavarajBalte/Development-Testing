package com.devTest.UnitTestingWithSpringJunitAndMockito.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Item {
    @Id
    private  int id;
    private String name;
    private int price;
    private int quantity;

    @Transient
    private int value;

}
