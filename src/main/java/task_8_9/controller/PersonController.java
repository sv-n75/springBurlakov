package task_8_9.controller;


import org.springframework.web.bind.annotation.*;

import task_8_9.model.Person;
import task_8_9.service.PersonService;

import java.util.List;


@RestController
@RequestMapping(path = "person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String hello() {
        return "Hallo";
    }


    @GetMapping("{name}")
    public Person getPersonByNameFromPathVariable(@PathVariable String name) {
        return personService.getPerson(name);
    }

    @DeleteMapping("/id/{id}")
    public String deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/id/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/persons")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PutMapping("/id/{id}")
    public String updatePerson(@PathVariable Long id,
                               @RequestParam Integer year) {
        return personService.updatePersonById(id, year);
    }
}
