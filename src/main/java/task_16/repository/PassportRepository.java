package task_16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_16.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
