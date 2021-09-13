package task_8_9.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task_8_9.model.Person;
import task_8_9.repositiry.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getPerson(String name) {
        Person person = personRepository.findFirstByName(name)
                .orElseThrow(() -> new IllegalStateException("Can't find person with name " + name));
        return person;
    }

    public String deletePerson(Long id) {
        personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Can't find with id " + id));
        personRepository.deleteById(id);
        return "This person with " + id + " is deleted";
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalStateException("Can't find with id " + id));
    }

    @Transactional
    public String updatePersonById(Long id, Integer year){
        Person person =personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Can't find with id " + id));
        person.setYear(year);
        return "This person with id " + id + " is updated";
    }
}

