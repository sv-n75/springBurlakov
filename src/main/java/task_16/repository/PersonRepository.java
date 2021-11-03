package task_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task_16.model.Person;
import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
