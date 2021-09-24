package task_11_12.dto;


import lombok.Getter;
import lombok.Setter;
import task_11_12.model.Person;

@Getter
@Setter
public class PersonDTO {


    private String surname;
    private String name;
    private String patronymic;
    private Integer age;

    public PersonDTO(String surname, String name, String patronymic, Integer age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }

    public PersonDTO(Person person) {
        surname = person.getSurname();
        name = person.getName();
        patronymic = person.getPatronymic();
        age = person.getYear();
    }
}
