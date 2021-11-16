package task_Strengthening_skills.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class OrderDtoAllClient {

    private Long id;
    private Integer number;
    private Date dateOfCreation;
    private String description;
    private Integer sum;
    private Integer clientId;


}
