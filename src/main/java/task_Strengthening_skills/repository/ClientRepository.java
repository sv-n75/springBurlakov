package task_Strengthening_skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_Strengthening_skills.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
