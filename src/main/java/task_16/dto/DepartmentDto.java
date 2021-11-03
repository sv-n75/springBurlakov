package task_16.dto;


import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import task_16.model.Department;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class DepartmentDto {

    private Long departmentId;

    private String departmentName;

    private List<PersonDepartmentDTO> personDepartmentDTOList;

}
