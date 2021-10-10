package task_13_14_15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task_13_14_15.model.Passport;
import task_13_14_15.service.PassportService;

import java.util.List;

@RestController
@RequestMapping
public class PassportController {

    @Autowired
    private PassportService passportService;

    @PostMapping("/passports")
    public String addListPassports(@RequestBody List<Passport>passportList){
        passportService.addPassports(passportList);
        return "Ok";
    }

    @PostMapping("/passport")
    public String addPassport(@RequestBody Passport passport){
        passportService.addPassport(passport);
        return "Ok";
    }
}
