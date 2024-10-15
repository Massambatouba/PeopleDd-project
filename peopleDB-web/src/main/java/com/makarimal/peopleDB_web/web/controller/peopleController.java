package com.makarimal.peopleDB_web.web.controller;

import com.makarimal.peopleDB_web.biz.model.Person;
import com.makarimal.peopleDB_web.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class peopleController {
    @Autowired
    private PersonRepository personRepository;

   /* public void PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    */
    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson() {
        Person person = new Person();
        return person;
    }

    @GetMapping
    public String showPeoplePage() {
        return "people";
    }

    @PostMapping
    public String savePerson(Person person) {
        System.out.println(person);
        personRepository.save(person);
        return "redirect:/people";
    }
}
