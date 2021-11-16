package task_Strengthening_skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task_Strengthening_skills.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
