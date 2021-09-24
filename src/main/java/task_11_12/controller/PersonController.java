package task_11_12.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task_11_12.converter.PersonConverter;
import task_11_12.dto.PersonDTO;
import task_11_12.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "person2")
public class PersonController {// через конвертор и через конструктор PersonDTO

    @Autowired
    PersonService personService;

    @Autowired
    PersonConverter personConverter;


    @GetMapping("/getPersons/{year}")
    public List<PersonDTO> getPersonList(@PathVariable Integer year) {
        return personService.getPersons(year).stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/getPersonsConverter/{year}")
    public List<PersonDTO> getPersonListYearConverter(@PathVariable Integer year) {
        return personConverter.modelToDtList(personService.getPersons(year));
    }

    @GetMapping("/persons")
    public List<PersonDTO> getAll() {
        return personService.getAll().stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/personsConverter")
    public List<PersonDTO> getAllConverter() {
        return personConverter.modelToDtList(personService.getAll());
    }

    @GetMapping("/getNameYear")
    public PersonDTO getPersonNameAndYear(@RequestParam String name, @RequestParam Integer year) {
        return new PersonDTO(personService.getPersonByNameAndYear(name, year));
    }

    @GetMapping("/getNameYearConverter")
    public PersonDTO getPersonDTONameAndYearConverter(@RequestParam String name, @RequestParam Integer year) {
        return personConverter.modelToDto(personService.getPersonByNameAndYear(name, year));
    }

    @GetMapping("/more")
    public List<PersonDTO> getMore() {
        return personService.getMore().stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/moreConverter")
    public List<PersonDTO> getMoreConverter() {
        return personConverter.modelToDtList(personService.getMore());
    }
}
