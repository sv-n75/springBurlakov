package task_11_12.converter;

import org.springframework.stereotype.Component;
import task_11_12.dto.PersonDTO;
import task_11_12.model.Person;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PersonConverter {

    public PersonDTO modelToDto(Person person) {
        return new PersonDTO(person.getSurname(), person.getName()
                , person.getPatronymic(), person.getYear());

    }

    public List<PersonDTO> modelToDtList(List<Person> personList) {
        return personList.stream().map(p -> modelToDto(p)).collect(Collectors.toList());
    }


}
