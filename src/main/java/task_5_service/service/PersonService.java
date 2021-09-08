package task_5_service.service;


import org.springframework.stereotype.Service;
import task_5_service.controller.dto.PersonDTO;
import task_5_service.model.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {


    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("john", 20));
        persons.add(new Person("joanna", 24));
        persons.add(new Person("bred", 50));
        persons.add(new Person("kate", 33));
    }

    public PersonDTO getPersonByPerson(Person person) {

        return persons.stream().filter(p -> p.getName().equals(person.getName())).findFirst()
                .map(p -> new PersonDTO(person.getName(), person.getAge()))
                .orElseThrow(() -> new IllegalStateException("This Person with name " + person.getName() + " not found"));
    }

    public PersonDTO getPersonByName(String name) {
        return persons.stream().filter(p -> p.getName().equals(name)).findFirst()
                .map(p -> new PersonDTO(p.getName(), p.getAge()))
                .orElseThrow(() -> new IllegalStateException("This Person with name " + name + " not found"));
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void updatePerson(String name, Person person) {
        persons.stream().filter(p -> p.getName().equals(name)).findFirst()
                .map(p -> {
                    p.setName(person.getName());
                    p.setAge(person.getAge());
                    return p;
                })
                .orElseThrow(() -> new IllegalStateException("This Person with name " + name + " not found"));

    }

    public void deletePerson(String name) {
        persons.stream().filter(p -> p.getName().equals(name)).findFirst()
                .map(p -> persons.remove(p))
                .orElseThrow(() -> new IllegalStateException("This Person with name " + name + " not found"));
    }

}
