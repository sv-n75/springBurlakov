package task_13_14_15.converter;

import org.springframework.stereotype.Component;
import task_13_14_15.dto.PassportDTO;
import task_13_14_15.model.Passport;

@Component
public class PassportConverter {

    public PassportDTO convertPassportToPassportDTO(Passport passport){
        return new PassportDTO(passport.getNumber(), passport.getSeries(), passport.getDateOfIssue());
    }
}
