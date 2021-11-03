package task_16.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task_16.dto.DepartmentDto;
import task_16.model.Department;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter {

    @Autowired
    private PersonConverter personConverter;

    public DepartmentDto converterDepartment(Department department) {
        return new DepartmentDto(department.getId(), department.getName()
                , department.getPersonsDepartments().stream()
                .map(p -> personConverter.convertToDepartmentDto(p)).collect(Collectors.toList()));
    }

    public List<DepartmentDto> converterDepartmentList(List<Department> departmentList) {
        return departmentList.stream().map(p -> converterDepartment(p)).collect(Collectors.toList());
    }
}
