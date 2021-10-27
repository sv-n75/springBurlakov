package task_13_14_15.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task_13_14_15.dto.PersonDTO;
import task_13_14_15.model.Person;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PersonConverter {

    @Autowired
    private PassportConverter passportConverter;

    public PersonDTO convertToDto(Person person) {
        return new PersonDTO(person.getSurname(), person.getName()
                , person.getPatronymic()
                , passportConverter.convertPassportToPassportDTO(person.getPersonPassport()));
    }

    public List<PersonDTO> convertToDtList(List<Person> personList) {
        return personList.stream().map(p -> convertToDto(p)).collect(Collectors.toList());
    }
}
