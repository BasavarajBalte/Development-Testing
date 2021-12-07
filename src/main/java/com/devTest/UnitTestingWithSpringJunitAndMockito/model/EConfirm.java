package com.devTest.UnitTestingWithSpringJunitAndMockito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbleconfirm")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EConfirm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int employeeId;
    private String employeeNo;
    private String name;
    private LocalDate confirmFrom;
    private LocalDate probationDate;

    public EConfirm(int employeeId, String employeeNo, String name, LocalDate confirmFrom, LocalDate probationDate) {
        this.employeeId = employeeId;
        this.employeeNo = employeeNo;
        this.name = name;
        this.confirmFrom = confirmFrom;
        this.probationDate = probationDate;
    }
}
