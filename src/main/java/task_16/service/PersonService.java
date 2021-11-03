package task_16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_16.converter.PersonConverter;
import task_16.dto.PersonDTO;
import task_16.exception.PersonException;
import task_16.exception.PersonExceptionEnum;
import task_16.model.Person;
import task_16.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {


    List<Person> personList = new ArrayList<>();


    @Autowired
    private PersonRepository personRepository;


    @Autowired
    private PersonConverter personConverter;



    public List<Person> getAll() {
        return personRepository.findAll();
    }


    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonException(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage()));
    }
    public void addPerson(Person person) {
        personList.add(person);
        personRepository.saveAll(personList);
    }

    public void addPersons(List<Person> people) {
        personList.addAll(people);
        personRepository.saveAll(personList);
    }

    public List<PersonDTO> getPersonsDTO() {
        return personConverter.convertToDtList(personRepository.findAll());
    }


}
