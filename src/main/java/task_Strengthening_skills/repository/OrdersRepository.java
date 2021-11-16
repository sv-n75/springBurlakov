package task_Strengthening_skills.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import task_Strengthening_skills.model.Order;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
