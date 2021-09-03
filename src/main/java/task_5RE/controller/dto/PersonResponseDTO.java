package task_5RE.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import task_5RE.model.Person;


@Data
@AllArgsConstructor
public class PersonResponseDTO {

    private String name;

    private Integer age;


}
