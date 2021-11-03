package task_16.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private String surname;
    private String name;
    private Integer age;
    private PassportDTO passportDTO;
}
