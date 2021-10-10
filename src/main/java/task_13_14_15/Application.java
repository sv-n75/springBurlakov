package task_13_14_15;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

// можно объединить таблицы здесь при запуске при наследовании от строки CommandLine
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Autowired
//    private PassportRepository passportRepository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Person> personList = new ArrayList<>(personRepository.findAll());
//        List<Passport>passportList = new ArrayList<>(passportRepository.findAll());
//        Iterator<Person> personIterator = personList.iterator();
//        Iterator<Passport>passportIterator = passportList.iterator();
//        while (personIterator.hasNext() && passportIterator.hasNext()){
//            personIterator.next().setPersonPassport(passportIterator.next());
//        }
//        personRepository.saveAll(personList);
//    }
}
