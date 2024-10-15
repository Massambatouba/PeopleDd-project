package com.makarimal.peopleDB_web.data;

import com.makarimal.peopleDB_web.biz.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Running this stuff here");
        if (personRepository.count() == 0) {
            List<Person> people = List.of(new Person(10l, "Jack", "Snake", "jack@gmail.com", LocalDate.of(1950, 1, 1),  new BigDecimal("50000")),
                    new Person(null, "Pete", "Smith", "pepe@gmail.com", LocalDate.of(1960, 2, 1), new BigDecimal("60000")),
                    new Person(null, "Jennifer", "Jackson","hennifier@gmail.com", LocalDate.of(1970, 3, 1), new BigDecimal("70000")),
                    new Person(null, "Marc", "Kim","marc@gmail.com", LocalDate.of(1980, 4, 1), new BigDecimal("80000")),
                    new Person(null, "Vishnu", "McGuire","vishnu@gmail.com", LocalDate.of(1980, 4, 1), new BigDecimal("80000")),
                    new Person(null, "Alice", "Smith","alice@gmail.com", LocalDate.of(1980, 4, 1), new BigDecimal("80000"))
            );
            personRepository.saveAll(people);
        }
    }
}
