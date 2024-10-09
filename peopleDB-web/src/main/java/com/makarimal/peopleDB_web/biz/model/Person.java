package com.makarimal.peopleDB_web.biz.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private BigDecimal salary;

    public String getFormattedDOB() {
        return DateTimeFormatter.ofPattern("MMMM dd, yyyy").format(dob);
    }

    public String getNumberFormatSALARY() {
        return NumberFormat.getCurrencyInstance().format(salary);
    }


}
