package task_13_14_15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_13_14_15.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
