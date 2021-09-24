package task_11_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task_11_12.model.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByNameAndYear(String name, Integer year);

    List<Person> findAllByYear(Integer year);


//    @Query("SELECT p FROM personnew p WHERE p.year > 30") - почему не работает ни в каком виде?????????
//    List<Person> findMoreThan();

    @Query(
            value = "SELECT * FROM personnew p WHERE p.year > 10",
            nativeQuery = true)
    List<Person> findMoreThan();
}
