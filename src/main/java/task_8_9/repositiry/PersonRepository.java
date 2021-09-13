package task_8_9.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import task_8_9.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findFirstByName(String name);

}
