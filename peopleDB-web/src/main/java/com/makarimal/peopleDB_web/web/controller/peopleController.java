package com.makarimal.peopleDB_web.web.controller;

import com.makarimal.peopleDB_web.biz.model.Person;
import com.makarimal.peopleDB_web.data.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class peopleController {
    @Autowired
    private PersonRepository personRepository;

    public void PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


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
    public String savePerson(@Valid Person person, Errors errors) {
        System.out.println(person);
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:/people";
        }
        return "people";
    }
    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections) {
        System.out.println(selections);
        if (selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";
    }

    @PostMapping(params = "edit=true")
    public String editPerson(@RequestParam Optional<List<Long>> selections, Model model) {
        System.out.println(selections);
        if (selections.isPresent()) {
            Optional<Person> person = personRepository.findById(selections.get().get(0));
            model.addAttribute("person", person);

        }
        return "people";
    }
}
