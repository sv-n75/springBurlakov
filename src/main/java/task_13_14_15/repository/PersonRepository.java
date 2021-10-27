package task_13_14_15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task_13_14_15.model.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
