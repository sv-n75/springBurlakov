package task_13_14_15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task_13_14_15.dto.PersonDTO;
import task_13_14_15.model.Person;
import task_13_14_15.service.PersonService;

import java.util.List;


@RestController
@RequestMapping(path = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return "This Person is added";
    }

    @PostMapping("/addPersons")
    public String addPersons(@RequestBody List<Person> personList) {
        personService.addPersons(personList);
        return "This Persons are added";
    }

    @GetMapping("/id/{id}")
    public PersonDTO getPersonDto(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/persons")
    public List<PersonDTO> personDTOList() {
        return personService.getPersonsDTO();
    }
}
