package task_16.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_16.converter.DepartmentConverter;
import task_16.dto.DepartmentDto;
import task_16.exception.PersonException;
import task_16.exception.PersonExceptionEnum;
import task_16.model.Department;
import task_16.model.Person;
import task_16.repository.DepartmentRepository;
import task_16.repository.PersonRepository;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private DepartmentConverter departmentConverter;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentService departmentService;



    public List<DepartmentDto> getDepartments() {
        return departmentConverter.converterDepartmentList(departmentRepository.findAll());
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public String deletePersonFromDep(Long personId) {
        Person person = personService.getPersonById(personId);
        if (person.getDepartment() == null) return "this Person is unemployed";
        person.setDepartment(null);
        personRepository.save(person);
        return "Person dismissed from the department";
    }

    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new PersonException(PersonExceptionEnum.DEPARTMENT_NOT_FOUND.getMessage()));
    }

    public String addPersonToDepartment(Long personId, Long departmentId) {
        Person person = personService.getPersonById(personId);
        if (person.getDepartment() != null) return "this Person is busy";
        person.setDepartment(departmentService.getDepartmentById(departmentId));
        personRepository.save(person);
        return "This Person added into the department";
    }

    public String deleteDepartment(Long departmentId) {
        departmentService.getDepartmentById(departmentId);//проверяем наличие департамента чтобы выбросить исключение
        departmentRepository.deleteById(departmentId);
        return "This Department is Deleted";
    }
}
