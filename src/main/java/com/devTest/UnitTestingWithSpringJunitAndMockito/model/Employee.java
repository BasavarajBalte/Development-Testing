package com.devTest.UnitTestingWithSpringJunitAndMockito.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Table(name = "tblemployee")
@Setter
@Getter
@NoArgsConstructor
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String employeeNo;
}
