package task_10.service;

import org.springframework.stereotype.Service;
import task_10.model.Person;
import task_10.reposirory.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPersons(Integer year) {
        List<Person> personList = personRepository.findAllByYear(year);
        return personList;
    }

    public Person getPersonByNameAndYear(String name, Integer year) {//
        Person person = personRepository.findByNameAndYear(name, year)
                .orElseThrow(() -> new IllegalStateException("Can't find person with name " + name
                        + " and year " + year));
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
