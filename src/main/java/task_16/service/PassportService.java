package task_16.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_16.model.Passport;
import task_16.repository.PassportRepository;

import java.util.List;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    public void addPassport(Passport passport) {
        passportRepository.save(passport);
    }

    public void addPassports(List<Passport> passportList) {
        passportRepository.saveAll(passportList);
    }
}

// [{

//         "series": "111",
//         "number": "11211",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "222",
//         "number": "11211",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "333",
//         "number": "11213",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "444",
//         "number": "11214",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "555",
//         "number": "11215",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "666",
//         "number": "11216",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "777",
//         "number": "11217",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "888",
//         "number": "11218",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "999",
//         "number": "11219",
//         "dateOfIssue": "2020-10-10"
//         },
//         {
//         "series": "101",
//         "number": "11220",
//         "dateOfIssue": "2020-10-10"
//         }
//         ]

