package com.makarimal.peopleDB_web.web;

import com.makarimal.peopleDB_web.biz.model.Person;
import com.makarimal.peopleDB_web.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class peopleController {

    private final PersonRepository personRepository;

    public peopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }

    @GetMapping
    public String showPeoplePage(Model model) {
        return "people";
    }
}
