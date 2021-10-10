package task_13_14_15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task_13_14_15.converter.PersonConverter;
import task_13_14_15.dto.PersonDTO;
import task_13_14_15.model.Person;
import task_13_14_15.service.PersonService;

import java.util.List;


@RestController
@RequestMapping(path = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonConverter personConverter;

    @GetMapping("/getPersons/{year}")
    public List<PersonDTO> getPersonListYear(@PathVariable Integer year) {
        return personService.getPersons(year);
    }

    @GetMapping("/getNameYear")
    public PersonDTO getPersonDTONameAndYear(@RequestParam String name, @RequestParam Integer year) {
        return personService.getPersonByNameAndYear(name, year);
    }

    @GetMapping("/more")
    public List<PersonDTO> getMore() {
        return personService.getMore();
    }

    @GetMapping("/union")
    public List<Person>  getUnion() {
       return personService.unionPersonPassport();
    }

    @GetMapping("/persons")
    public List<Person> getAll(){
        return personService.getAll();
    }
}
