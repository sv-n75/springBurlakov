package task_5RE.controller;


import org.springframework.web.bind.annotation.*;

import task_5RE.controller.dto.PersonResponseDTO;
import task_5RE.model.Person;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {

    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("john", 20));
        persons.add(new Person("joanna", 24));
        persons.add(new Person("bred", 50));
        persons.add(new Person("kate", 33));
    }

    @GetMapping("{name}")
    public Object getPersonByNameFromPathVariable(@PathVariable String name) {
        for (Person person : persons) {
            if (person.getName().equals(name))
                return new PersonResponseDTO(person.getName(), person.getAge());
        }
        return new IllegalStateException("This Person with name " + name + " not found");
    }

    @GetMapping("/get-name")
    public Object getPersonByNameFromRequestParam(@RequestParam String name) {
        for (Person person : persons) {
            if (person.getName().equals(name))
                return new PersonResponseDTO(person.getName(), person.getAge());
        }
        return
                new IllegalStateException("This Person with name " + name + " not found");
    }

    @GetMapping("/description")
    public Object getPersonByNameResponseBody(@RequestBody Person person) {
        for (Person p : persons) {
            if (p.getName().equals(person.getName()))
                return new PersonResponseDTO(person.getName(), person.getAge());
        }
        return new IllegalStateException("This Person with name " + person.getName() + " not found");
    }

    @PostMapping
    public String addNewPerson(@RequestBody Person person) {
        for (Person p : persons) {
            if ((p.getName().equals(person.getName()) && (p.getAge().equals(person.getAge()))))
                return "this person is taken";
        }
        persons.add(person);
        System.out.println(persons);
        return "this person is added";//можно сделать void выбрасывать исключение как лучше?

    }

    @PutMapping("{name}")
    public String updatePerson(@PathVariable String name, @RequestBody Person person) {
        for (Person p : persons) {
            if (p.getName().equals(name)) {
                p.setName(person.getName());
                p.setAge(person.getAge());
                return "This person is update";//аналогично верхнему
            }
        }
        return "This person does not exist";
    }

    @DeleteMapping("{name}")
    public void deletePerson(@PathVariable String name) {
        for (Person p : persons) {
            if (p.getName().equals(name)) {
                persons.remove(p);
                System.out.println(persons);
                return;
            }
        }
        throw new IllegalStateException("This person does not exist");
    }
}



