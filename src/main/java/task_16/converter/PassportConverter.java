package task_16.converter;

import org.springframework.stereotype.Component;
import task_16.dto.PassportDTO;
import task_16.model.Passport;


@Component
public class PassportConverter {
    public PassportDTO convertPassportToPassportDTO(Passport passport) {
        return new PassportDTO(passport.getNumber(), passport.getSeries(), passport.getDateOfIssue());
    }
}
