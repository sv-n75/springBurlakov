package task_16.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task_16.model.Passport;
import task_16.service.PassportService;

import java.util.List;

@RestController
@RequestMapping
public class PassportController {

    @Autowired
    private PassportService passportService;

    @PostMapping("/passports")
    public String addListPassports(@RequestBody List<Passport> passportList) {
        passportService.addPassports(passportList);
        return "Ok";
    }

    @PostMapping("/passport")
    public String addPassport(@RequestBody Passport passport) {
        passportService.addPassport(passport);
        return "Ok";
    }
}
