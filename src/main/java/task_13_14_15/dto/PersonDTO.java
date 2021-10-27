package task_13_14_15.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private String surname;
    private String name;
    private String patronymic;
    private PassportDTO passportDTO;
}
