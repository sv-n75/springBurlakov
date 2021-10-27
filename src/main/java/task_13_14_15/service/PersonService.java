package task_13_14_15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_13_14_15.converter.PersonConverter;
import task_13_14_15.dto.PersonDTO;
import task_13_14_15.exception.PersonException;
import task_13_14_15.exception.PersonExceptionEnum;
import task_13_14_15.model.Person;
import task_13_14_15.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    List<Person> personList = new ArrayList<>();

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonConverter personConverter;

    public void addPerson(Person person) {
        personList.add(person);
        personRepository.saveAll(personList);
    }

    public void addPersons(List<Person> people) {
        personList.addAll(people);
        personRepository.saveAll(personList);
    }

    public PersonDTO getPersonById(Long id) {
        return personConverter.convertToDto(personRepository.findById(id)
                .orElseThrow(() -> new PersonException(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage())));
    }

    public List<PersonDTO> getPersonsDTO() {
        return personConverter.convertToDtList(personRepository.findAll());
    }
}
