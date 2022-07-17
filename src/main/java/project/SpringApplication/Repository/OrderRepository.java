package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}