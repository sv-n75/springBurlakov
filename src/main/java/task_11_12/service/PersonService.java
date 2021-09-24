package task_11_12.service;

import org.springframework.stereotype.Service;
import task_11_12.exception.PersonException;
import task_11_12.exception.PersonExceptionEnum;
import task_11_12.model.Person;
import task_11_12.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPersons(Integer year) {
        List<Person>personList = personRepository.findAllByYear(year);
        if (personList.isEmpty())
            throw new PersonException(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage());
        return personRepository.findAllByYear(year);
    }

    public Person getPersonByNameAndYear(String name, Integer year) {
        Person person = personRepository.findByNameAndYear(name, year);
        if (person == null) throw new PersonException(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage());
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public List<Person> getMore() {
        return personRepository.findMoreThan();
    }
}
