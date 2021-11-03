package task_16.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task_16.dto.DepartmentDto;
import task_16.model.Department;
import task_16.service.DepartmentService;
import task_16.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartment() {
        return departmentService.getDepartments();
    }

    @PostMapping("/departments")
    public String addNewDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return "this departments with name " + department.getName() + " is added";
    }

    @PutMapping("/departmentPerson/{id}")
    public String deletePersonFromDepartment(@PathVariable Long id) {
        return departmentService.deletePersonFromDep(id);
    }

    @PutMapping("/departmentPerson")
    public String addPersonIntoDepartment(@RequestParam Long pId, @RequestParam Long dId) {
        return departmentService.addPersonToDepartment(pId, dId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }

}
