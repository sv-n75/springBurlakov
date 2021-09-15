package task_10.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task_10.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByNameAndYear(String name, Integer year);

    List<Person> findAllByYear(Integer year);// здесь как лучше через Optional если исключение?
}
