package task_16.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import task_16.converter.PersonConverter;
import task_16.dto.PersonDTO;
import task_16.model.Person;
import task_16.service.PersonService;

import java.util.List;


@RestController
@RequestMapping(path = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonConverter personConverter;

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
    public Person getPersonDto(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/persons")
    public List<PersonDTO> personDTOList() {
        return personService.getPersonsDTO();
    }

}
