package task_16.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class PassportDTO {

    private String series;
    private String number;
    private LocalDate localDate;
}
