package task_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_16.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
