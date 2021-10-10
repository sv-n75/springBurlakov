package task_13_14_15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_13_14_15.converter.PersonConverter;
import task_13_14_15.dto.PersonDTO;
import task_13_14_15.exception.PersonException;
import task_13_14_15.exception.PersonExceptionEnum;
import task_13_14_15.model.Passport;
import task_13_14_15.model.Person;
import task_13_14_15.repository.PassportRepository;
import task_13_14_15.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private PersonConverter personConverter;

    public List<Person> unionPersonPassport() {
        List<Person> personList = new ArrayList<>(personRepository.findAll());
        List<Passport> passportList = new ArrayList<>(passportRepository.findAll());

        Iterator<Person> personIterator = personList.iterator();
        Iterator<Passport> passportIterator = passportList.iterator();
        while (personIterator.hasNext() && passportIterator.hasNext()) {
            personIterator.next().setPersonPassport(passportIterator.next());
        }
        personRepository.saveAll(personList);
        return personRepository.findAll();
    }

    public List<PersonDTO> getPersons(Integer year) {
        List<PersonDTO> personListDTO = personConverter.convertToDtList(personRepository.findAllByYear(year));
        if (personListDTO.isEmpty())
            throw new PersonException(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage());
        return personListDTO;
    }

    public PersonDTO getPersonByNameAndYear(String name, Integer year) {
        PersonDTO personDTO = personConverter.convertToDto(personRepository.findByNameAndYear(name, year));
        if (personDTO == null) throw new PersonException(PersonExceptionEnum.PERSON_NOT_FOUND.getMessage());
        return personDTO;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public List<PersonDTO> getMore() {
        return personConverter.convertToDtList(personRepository.findMoreThan());
    }
}
