package com.makarimal.peopleDB_web.biz.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String firstname;
    private String lastName;
    private LocalDate dob;
    private BigDecimal salary;
}
