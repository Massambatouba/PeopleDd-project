package com.makarimal.peopleDB_web.web.controller;

import com.makarimal.peopleDB_web.biz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class peopleController {

    @GetMapping
    public String getPeople(Model model) {
        List<Person> people = List.of(new Person(10l, "Jack", "Snake", LocalDate.of(1950, 1, 1), new BigDecimal("50000")),
        new Person(null, "Pete", "Smith", LocalDate.of(1960, 2, 1), new BigDecimal("60000")),
        new Person(null, "Jennifer", "Jackson", LocalDate.of(1970, 3, 1), new BigDecimal("70000")),
        new Person(null, "Marc", "Kim", LocalDate.of(1980, 4, 1), new BigDecimal("80000")),
        new Person(null, "Alice", "McGuire", LocalDate.of(1980, 4, 1), new BigDecimal("80000")),
        new Person(null, "Akire", "Smith", LocalDate.of(1980, 4, 1), new BigDecimal("80000"))
        );
        model.addAttribute("people", people);
        return "people";
    }
}
