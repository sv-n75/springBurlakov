package task_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_5.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
