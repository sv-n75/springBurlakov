package task_10.controller;


import org.springframework.web.bind.annotation.*;
import task_10.model.Person;
import task_10.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(path = "person2")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String hello() {
        return "Hallo!!!!!";
    }

    @GetMapping("/getPersons/{year}")
    public List<Person> getPersonList(@PathVariable Integer year) {
        return personService.getPersons(year);
    }

    @GetMapping("/persons")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/getNameYear")
    public Person getPersonNameAndYear(@RequestParam String name, @RequestParam Integer year) {
        return personService.getPersonByNameAndYear(name, year);
        // наверное уместнее было бы возвращать список вдруг совпадение? И нужно и можно ли оставлять вспомогательныне
        // методы (getAll(), hello()) - они используются в процессе выполнения. Блин пробовал через @Query но так и не вышло...
    }
}
