package task_16.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import task_16.model.Person;

@Getter
@Setter
@AllArgsConstructor
public class PersonDepartmentDTO {
    private String personSurname;
    private String personName;
    private Integer personAge;
}
