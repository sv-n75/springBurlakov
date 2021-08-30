package task_5.controller.dto;

import lombok.Data;
import task_5.model.Person;

@Data
public class PersonResponseDTO {

    private Long id;

    private String name;

    private Integer age;

    public PersonResponseDTO(Person person){
        id = person.getId();
        name = person.getName();
        age = person.getAge();
    }

    public PersonResponseDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
