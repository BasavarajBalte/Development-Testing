package com.devTest.UnitTestingWithSpringJunitAndMockito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//commented table script executed from schema.sql
@Table(name = "tblemployee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    //commented GeneratedValue script executed from schema.sql
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String employeeNo;

    public Employee(String name, String employeeNo) {
        this.name = name;
        this.employeeNo = employeeNo;
    }
}
